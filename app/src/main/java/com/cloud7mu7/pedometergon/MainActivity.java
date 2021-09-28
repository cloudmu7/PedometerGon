package com.cloud7mu7.pedometergon;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    TextView Dtv;
    TimeZone tz;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragement_main);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd", Locale.KOREAN);
        Dtv = (TextView) findViewById(R.id.Main_time);
        tz = TimeZone.getTimeZone("Asia/Seoul");
        simpleDateFormat.setTimeZone(tz);

        Date date = new Date();
        String time = simpleDateFormat.format(date);
        Dtv.setText(time);

    }
}
