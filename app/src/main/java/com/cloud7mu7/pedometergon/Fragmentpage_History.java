package com.cloud7mu7.pedometergon;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class Fragmentpage_History extends Fragment {

    HistoryAdapter adapter;
    ArrayList<String> arrayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragement_history, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_history);

        arrayList = new ArrayList<>();
        arrayList.add("첫번째 용");
        arrayList.add("두번째 용");
        arrayList.add("세번째 용");
        arrayList.add("네번째 용");

        recyclerView.setHasFixedSize(true);
        adapter = (HistoryAdapter) new HistoryAdapter(getActivity(), arrayList);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter((RecyclerView.Adapter) adapter);

        return view;
    }



}