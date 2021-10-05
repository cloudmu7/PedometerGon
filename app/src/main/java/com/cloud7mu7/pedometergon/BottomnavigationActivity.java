package com.cloud7mu7.pedometergon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class BottomnavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottomnavigation_main);

        Fragment menu1 = new MainFragment();
        Fragment menu2 = new HistoryFragment();
        Fragment menu3 = new FriendFragment();
        Fragment menu4 = new OptionFragment();

        FragmentManager fragmentManager;

        getSupportFragmentManager().beginTransaction().replace(R.id.content_layout, menu1).commitAllowingStateLoss();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomnavi);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.navi_main:
                        getSupportFragmentManager().beginTransaction().replace(R.id.content_layout, menu1).commitAllowingStateLoss();
                        return true;

                    case R.id.navi_history:
                        getSupportFragmentManager().beginTransaction().replace(R.id.content_layout, menu2).commitAllowingStateLoss();
                        return true;
                    case R.id.navi_friend:
                        getSupportFragmentManager().beginTransaction().replace(R.id.content_layout, menu3).commitAllowingStateLoss();
                        return true;

                    case R.id.navi_option:
                        getSupportFragmentManager().beginTransaction().replace(R.id.content_layout, menu4).commitAllowingStateLoss();
                        return true;

                    default:
                        return false;
                }
            }
        });
    }
}