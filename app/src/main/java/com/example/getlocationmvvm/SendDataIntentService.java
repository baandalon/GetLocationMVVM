package com.example.getlocationmvvm;

import android.Manifest;
import android.app.IntentService;
import android.app.Notification;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Looper;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

import static com.example.getlocationmvvm.App.CHANNEL_ID;

public class SendDataIntentService extends IntentService {

    private PowerManager.WakeLock wakeLock;

    public SendDataIntentService(){
        super("SendDataIntentService");
        setIntentRedelivery(true);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("intent", "onCreate");
        PowerManager powerManager = (PowerManager) getSystemService(POWER_SERVICE);
        wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,
                "Example:Wakelock");
        wakeLock.acquire(3600);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            Notification notification = new Notification.Builder(this,
                    CHANNEL_ID)
                    .setContentTitle("Example")
                    .setContentText("Running...")
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .build();
            startForeground(1, notification);
        }
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.e("intent", "onHandleIntent");
        String input = intent.getStringExtra("inputExtra");
        for(int i = 0; i < 10; i++){
            getCurrentLocation();
            SystemClock.sleep(1000);
        }
    }


    private Location getCurrentLocation() {
        final Location data = null;
        final LocationRequest locationRequest = new LocationRequest();
        locationRequest.setInterval(1000);
        locationRequest.setFastestInterval(500);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            return data;
        }

        LocationServices.getFusedLocationProviderClient(SendDataIntentService.this)
                .requestLocationUpdates(locationRequest, new LocationCallback() {
                    @Override
                    public void onLocationResult(LocationResult locationResult) {
                        super.onLocationResult(locationResult);
                        LocationServices.getFusedLocationProviderClient(SendDataIntentService.this)
                                .removeLocationUpdates(this);
                        if (locationResult != null && locationResult.getLocations().size() > 0) {
                            int latestLocationIndex = locationResult.getLocations().size() - 1;
                            double latitude =
                                    locationResult.getLocations().get(latestLocationIndex).getLatitude();
                            double longitude =
                                    locationResult.getLocations().get(latestLocationIndex).getLongitude();
                            Log.e("intent latttt", String.valueOf(latitude));
                            Log.e("intent lonnnn", String.valueOf(longitude));
                        }
                    }
                }, Looper.getMainLooper());

        return data;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("intent", "onDestroy");
        wakeLock.release();
        Log.e("intent", "Wakelock released");
    }
}
