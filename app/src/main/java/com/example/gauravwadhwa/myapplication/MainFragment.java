package com.example.gauravwadhwa.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by gauravwadhwa on 09/03/16.
 */
public class MainFragment extends Fragment {


    public static MainFragment newInstance() {

        Bundle args = new Bundle();
        args.putInt("DATA", 1);

        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);
        ((TextView)view.findViewById(R.id.view)).setText("xyz");
        view.findViewById(R.id.view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getArguments().remove("DATA");
//                getArguments().putInt("DATA", i + 1);
            }
        });
        return view;
    }
}
