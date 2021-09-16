package com.cloud7mu7.pedometergon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class List_adapter extends BaseAdapter {

    Context context;

    private ArrayList<List_History> list_His = new ArrayList<>();


    @Override
    public int getCount() {
        return list_His.size();
    }

    @Override
    public Object getItem(int position) {
        return list_His.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_history, null);
        return null;
    }
}
