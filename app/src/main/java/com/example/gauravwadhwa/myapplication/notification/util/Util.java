package com.example.gauravwadhwa.myapplication.notification.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by gauravwadhwa on 15/03/16.
 */
public class Util {

    public static final String TIME_HH_MM = "hh:mm";
    public static final String TIME_HH_MM_AA = "hh:mm aa";

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat();


    public static String formatTime(long time, String format) {
        simpleDateFormat.applyPattern(format);
        return simpleDateFormat.format(new Date(time));
    }
}
