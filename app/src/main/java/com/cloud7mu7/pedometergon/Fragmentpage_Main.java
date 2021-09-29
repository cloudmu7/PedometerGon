package com.cloud7mu7.pedometergon;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Fragmentpage_Main extends Fragment {

    TextView tv_time;
    TimeZone tz;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd", Locale.KOREAN);

    private SensorManager sensorManager;
    private Sensor Countersensor;

    int nowSteps = 0;
    int doingSteps = 0;
    TextView tv_steps;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragement_main, null);
        tv_time=view.findViewById(R.id.Main_time);

        //시간 설정
        tz = TimeZone.getTimeZone("Asia/Seoul");
        simpleDateFormat.setTimeZone(tz);

        Date date = new Date();
        String time = simpleDateFormat.format(date);
        tv_time.setText(time);

        //걸음 센서 설정

        tv_steps = view.findViewById(R.id.sensor);

        sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        Countersensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);

        if(Countersensor==null){
            Toast.makeText(getContext(), "X", Toast.LENGTH_SHORT).show();
        }

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        if(Countersensor!=null){
            sensorManager.registerListener((SensorEventListener) this,Countersensor,SensorManager.SENSOR_DELAY_GAME);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if(sensorManager!=null){
            sensorManager.unregisterListener((SensorEventListener) this);
        }
    }

    public void sensorChanged(SensorEvent event){
        if(event.sensor.getType()==Sensor.TYPE_STEP_COUNTER){
            if(doingSteps<1){
                doingSteps = (int)event.values[0];
            }
            nowSteps = (int) event.values[0] - doingSteps;
            tv_steps.setText(Integer.toString(nowSteps));
        }
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}


