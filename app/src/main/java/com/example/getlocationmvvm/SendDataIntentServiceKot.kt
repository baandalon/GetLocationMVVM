package com.example.getlocationmvvm

import android.Manifest
import android.app.IntentService
import android.app.Notification
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Looper
import android.os.PowerManager
import android.os.PowerManager.WakeLock
import android.os.SystemClock
import android.util.Log
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class SendDataIntentServiceKot : IntentService("SendDataIntentServiceKot") {

    var wakeLock: WakeLock? = null
    override fun onCreate() {
        super.onCreate()
        Log.e("intent", "onCreate")
        val powerManager = getSystemService(Context.POWER_SERVICE) as PowerManager
        wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,
                "Example:Wakelock")
//        wakeLock.acquire()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notification = Notification.Builder(this,
                    App.CHANNEL_ID)
                    .setContentTitle("Example")
                    .setContentText("Running...")
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .build()
            startForeground(1, notification)
        }
    }

    override fun onHandleIntent(intent: Intent?) {
        Log.e("intent", "onHandleIntent")
        val input = intent!!.getStringExtra("inputExtra")
        for (i in 0..9) {
            currentLocation()

        }
        wakeLock?.acquire(0)
    }

    fun currentLocation() {
        GlobalScope.launch {
            runBlocking {

                val locationRequest = LocationRequest()
                locationRequest.interval = 1000
                locationRequest.fastestInterval = 500
                locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
                if (ActivityCompat.checkSelfPermission(this@SendDataIntentServiceKot, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                                this@SendDataIntentServiceKot, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    return@runBlocking
                }
                LocationServices.getFusedLocationProviderClient(this@SendDataIntentServiceKot)
                        .requestLocationUpdates(locationRequest, object : LocationCallback() {
                            override fun onLocationResult(locationResult: LocationResult) {
                                super.onLocationResult(locationResult)
                                LocationServices.getFusedLocationProviderClient(this@SendDataIntentServiceKot)
                                        .removeLocationUpdates(this)
                                if (locationResult != null && locationResult.locations.size > 0) {
                                    val latestLocationIndex = locationResult.locations.size - 1
                                    val latitude = locationResult.locations[latestLocationIndex].latitude
                                    val longitude = locationResult.locations[latestLocationIndex].longitude
                                    Log.e("intent latttt", latitude.toString())
                                    Log.e("intent lonnnn", longitude.toString())

                                    //                            fetchAddressFromLatLong(location);
                                }
                            }
                        }, Looper.getMainLooper())

                SystemClock.sleep(1000)
            }

        }

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("intent", "onDestroy")
        wakeLock!!.release()
        Log.e("intent", "Wakelock released")
    }

    init {
        setIntentRedelivery(true)
    }
}