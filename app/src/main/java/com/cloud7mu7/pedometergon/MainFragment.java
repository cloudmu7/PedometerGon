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

public class MainFragment extends Fragment {

    TextView tv_time;
    TimeZone tz;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd", Locale.KOREAN);

    TextView tv_steps;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragement_main, null);
        tv_time = view.findViewById(R.id.Main_time);

        //시간 설정
        tz = TimeZone.getTimeZone("Asia/Seoul");
        simpleDateFormat.setTimeZone(tz);

        Date date = new Date();
        String time = simpleDateFormat.format(date);
        tv_time.setText(time);



        return view;
    }

}

