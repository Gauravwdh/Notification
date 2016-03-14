package com.example.gauravwadhwa.myapplication.notification;

import android.util.Log;

/**
 * Created by gauravwadhwa on 14/03/16.
 */
public class Logger {

    public static void log(String tag, Object object) {
        Log.d(tag, "" + object);
    }
}
