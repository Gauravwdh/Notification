package com.example.gauravwadhwa.myapplication;

import android.app.Application;

/**
 * Created by gauravwadhwa on 23/07/15.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        takeId(Constant.ID);

    }

    private void takeId(@CompanyId int id) {

    }
}
