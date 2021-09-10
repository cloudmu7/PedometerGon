package com.cloud7mu7.pedometergon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bnv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnv = findViewById(R.id.bnv_main);
        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                return true;
            }
        });
        bnv.setSelectedItemId(R.id.navi_main);
    }

    private void BottomNavigate(int id){
        String tag = String.valueOf(id);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment nowFrag = fragmentManager.getPrimaryNavigationFragment();
        if(nowFrag != null){
            fragmentTransaction.hide(nowFrag);
        }

        Fragment frag = fragmentManager.findFragmentByTag(tag);
        if(frag == null){
            if(id == R.id.navi_main){
                frag = new Fragmentpage_Main();

            }else if(id == R.id.navi_history){
                frag = new Fragmentpage_History();

            }else if(id == R.id.navi_friend){
                frag = new Fragmentpage_Friend();

            }else {
                frag = new Fragmentpage_Option();
            }

            fragmentTransaction.add(R.id.content_layout, frag, tag);
        }else{
            fragmentTransaction.show(frag);
        }

        fragmentTransaction.setPrimaryNavigationFragment(frag);
        fragmentTransaction.setReorderingAllowed(true);
        fragmentTransaction.commitNow();
    }

}
