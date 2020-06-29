package com.example.getlocationmvvm;


import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class FetchOtherQr extends AppCompatActivity {

//    private BarcodeDetector barcodeDetector;
//    private SurfaceView cameraPreview;
//    private CameraSource cameraSource;
    private final int RequestCameraPermissionID = 1001;
    private TextView texto;
    private String qrResult;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case RequestCameraPermissionID: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                            != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
//                    try {
//                        cameraSource.start(cameraPreview.getHolder());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
                }
            }
            break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_qreader);
//
//        //Casting widgets
//        cameraPreview = (SurfaceView) findViewById(R.id.cameraPreview);
//        texto = (TextView) findViewById(R.id.text);
//
//        //Set builder for BarcodeDetector, this initialize BarcodeDetector to ajust algorithm to QR_CODE
//        barcodeDetector = new BarcodeDetector.Builder(this)
//                .setBarcodeFormats(Barcode.QR_CODE)
//                .build();
//
//        //Initialize cameraSource to adjust source of camera.
//        cameraSource = new CameraSource.Builder(this, barcodeDetector)
//                .setRequestedPreviewSize(640, 480)
//                .build();

    }

    @Override
    protected void onStart() {
        super.onStart();
        scanQR();
//        cameraPreview.setOnClickListener(v -> {
//            try {
//                if(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
//                    //Request Permission
//                    ActivityCompat.requestPermissions(QreaderActivity.this, new String[]{Manifest.permission.CAMERA}, RequestCameraPermissionID);
//                    return;
//                }
//                cameraSource.start(cameraPreview.getHolder());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            scanQR();
//        });
    }
    @Override
    protected void onStop() {
        super.onStop();
//        cameraSource.stop();
    }

    //Metodo para escanear por medio de QR y obtener los datos.
    private void scanQR(){
        //Event
//        cameraPreview.getHolder().addCallback(new SurfaceHolder.Callback() {
//            @Override
//            public void surfaceCreated(SurfaceHolder holder) {
//                if(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
//                    //Request Permission
//                    ActivityCompat.requestPermissions(QreaderActivity.this, new String[]{Manifest.permission.CAMERA}, RequestCameraPermissionID);
//                    return;
//                }
//                try{
//                    cameraSource.start(cameraPreview.getHolder());
//                }catch (IOException e){
//                    e.printStackTrace();
//                }
//            }
//            @Override
//            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
//
//            }
//            @Override
//            public void surfaceDestroyed(SurfaceHolder holder) {
//                cameraSource.stop();
//            }
//        });
//        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
//            @Override
//            public void release() {
//            }
//            @Override
//            public void receiveDetections(Detector.Detections<Barcode> detections) {
//                final SparseArray<Barcode> qrcodes = detections.getDetectedItems();
//                if(qrcodes.size()!=0){
//                    Vibrator vibrator = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
//                    vibrator.vibrate(250);
//                    texto.post(() -> {
//                        qrResult = qrcodes.valueAt(0).displayValue;
//                        texto.setText(qrResult);
//                        cameraSource.stop();
//                        Intent intent = new Intent();
//                        intent.putExtra("qrCode", qrResult);
//                        setResult(-1, intent);
//                        finish();
//                    });
//                }
//            }
//        });
    }
    //metodo para hacer login mediante la api, usando los parametrso resultantes del scaneo del QR.

}