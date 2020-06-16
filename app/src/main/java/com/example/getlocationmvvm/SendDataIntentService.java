package com.example.getlocationmvvm;

import android.Manifest;
import android.app.IntentService;
import android.app.Notification;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import static com.example.getlocationmvvm.App.CHANNEL_ID;

public class SendDataIntentService extends IntentService {

    private PowerManager.WakeLock wakeLock;
    private ResultReceiver resultReceiver;

    public SendDataIntentService(){
        super("SendDataIntentService");
        setIntentRedelivery(true);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("intent", "onCreate");
        resultReceiver = new AddressResultReceiver(new Handler());
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
        Location dataReceived;
        for(int i = 0; i < 10; i++){
            Log.e("intent", input + " - " + i);
            dataReceived = getCurrentLocation();
            SystemClock.sleep(1000);
            Log.e("intent data", "latitude " + dataReceived.getLatitude()
                    + "\n longitude " +  dataReceived.getLongitude());
            SystemClock.sleep(1000);
        }
    }

    private class AddressResultReceiver extends ResultReceiver{
        public AddressResultReceiver(Handler handler) {
            super(handler);
        }

        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            super.onReceiveResult(resultCode, resultData);
            if(resultCode == Constants.SUCCESS_RESULT){
                txtAddress.setText(resultData.getString(Constants.RESULT_DATA_KEY));
            }else{
                Toast.makeText(MainActivity.this, resultData.getString(Constants.RESULT_DATA_KEY),
                        Toast.LENGTH_SHORT).show();
            }
            progressBar.setVisibility(View.GONE);
        }
    }

    private Location getCurrentLocation() {
        final Location data = null;
        final LocationRequest locationRequest = new LocationRequest();
        locationRequest.setInterval(1000);
        locationRequest.setFastestInterval(500);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
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

                            data.setLatitude(latitude);
                            data.setLongitude(longitude);
//                            fetchAddressFromLatLong(location);
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
