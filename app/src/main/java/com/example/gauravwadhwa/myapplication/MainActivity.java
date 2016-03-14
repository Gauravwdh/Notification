package com.example.gauravwadhwa.myapplication;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;


public class MainActivity extends ActionBarActivity {

    private static final String TAG = MainActivity.class.getName();
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        debug("Main: " + Thread.currentThread().getName());
//        findViewById(R.id.layout);
//        MainFragment mainFragment = MainFragment.newInstance();
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction().add(R.id.layout, mainFragment).commit();

        recyclerView = (RecyclerView) findViewById(R.id.view);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new MyAdapter());
        scrollToPosition(50);
    }

    private void scrollToPosition(int position) {
        Observable.just(position).
                delay(500, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        recyclerView.smoothScrollToPosition(integer);
                        Observable.just(integer).
                                delay(500, TimeUnit.MILLISECONDS)
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Action1<Integer>() {
                                    @Override
                                    public void call(Integer integer) {
                                        View viewByPosition = linearLayoutManager.findViewByPosition(integer);
                                        recyclerView.smoothScrollBy(0, (int) viewByPosition.getY());
                                    }
                                });

                    }
                });
    }

    public static void debug(Object object) {
        Log.d(TAG, "" + object);
    }


    private class ItemTime {

        private long t = 0;
        private float[] time;

        private ItemTime(int length) {
            time = new float[length];
            for (Float i : time) {
                i = 0f;
            }
        }

        void scrollChanged(int startIndex, int endIndex) {
            long curr = System.currentTimeMillis();
            if (t != 0) {
                for (int i = startIndex; i < endIndex; i++) {
                    time[i] += (curr - t) / 1000f;
                }
            }
            t = System.currentTimeMillis();
//            debug(startIndex + " : " + endIndex);
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < time.length; i++) {
                stringBuffer.append(i + ":" + time[i] + " ");
            }
            debug(stringBuffer);
        }

    }

}
