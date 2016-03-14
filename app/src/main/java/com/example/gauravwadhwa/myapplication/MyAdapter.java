package com.example.gauravwadhwa.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by gauravwadhwa on 05/03/16.
 */
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private String[] str = new String[100];

    public MyAdapter() {
        for (int i = 0; i < str.length; i++) {
            str[i] = "Recycle view string : " + i;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.notification, parent, false);
        return new Vh(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((Vh) holder).onBind(str[position]);
    }

    @Override
    public int getItemCount() {
        return str.length;
    }

    private class Vh extends RecyclerView.ViewHolder {

        TextView textView;

        public Vh(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_notification);

        }

        void onBind(String str) {
            textView.setText(str);
        }
    }
}
