package com.cloud7mu7.pedometergon;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class pedometer extends AppCompatActivity {

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

        Toast.makeText(this, "성공", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onResume() {
        super.onResume();
        sensorManager.registerListener((SensorEventListener) this, countersensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onPause() {
        super.onPause();
        sensorManager.unregisterListener((SensorEventListener) this);
    }

    public void onSensorChanged(SensorEvent event) {

        switch (event.sensor.getType()) {
            case Sensor.TYPE_STEP_DETECTOR:
                tv_steps.setText("" + (++steps));
                break;
        }
    }

    public void onFragmentChange(View view){
    }
}
