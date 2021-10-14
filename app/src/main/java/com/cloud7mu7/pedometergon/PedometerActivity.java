package com.cloud7mu7.pedometergon;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class PedometerActivity extends AppCompatActivity implements SensorEventListener {



    SensorManager sensorManager;
    Sensor countersensor;

    int steps = 0;
    TextView tv_steps;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragement_main);

        //걸음 센서 설정

        tv_steps = findViewById(R.id.sensor);
        tv_steps.setText("0");
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        countersensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);

    }

    public void checkPermission() {
        //권한 설정, requestCode 100으로 세팅

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.BODY_SENSORS) == PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.BODY_SENSORS)){
                // 참고
            }
        }else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.BODY_SENSORS},100);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==100 && grantResults.length>0){
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
            }
            if(grantResults[1]==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        sensorManager.registerListener(this, countersensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    public void onSensorChanged(SensorEvent event) {

        switch (event.sensor.getType()) {
            case Sensor.TYPE_STEP_DETECTOR:
                tv_steps.setText("" + (++steps));
                break;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

}
