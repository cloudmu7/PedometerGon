package com.cloud7mu7.pedometergon;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainHistory extends AppCompatActivity {

    Fragmentpage_History fragmentpageHistory;
    ArrayList<String> items = new ArrayList<>();

    RecyclerView recyclerView;
    HistoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.fragement_history);

        items.add(new String("첫번째 용"));
        items.add(new String("두번째 용"));
        items.add(new String("세번째 용"));
        items.add(new String("네번째 용"));

        recyclerView = findViewById(R.id.recycler_history);
        adapter = new HistoryAdapter(this, items);
        recyclerView.setAdapter(adapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        fragmentpageHistory = new Fragmentpage_History();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentpageHistory).commit();

    }

}
