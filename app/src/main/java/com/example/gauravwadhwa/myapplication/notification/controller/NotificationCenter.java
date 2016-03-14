package com.example.gauravwadhwa.myapplication.notification.controller;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.content.Context;

import com.example.gauravwadhwa.myapplication.notification.NotificationEventListener;

/**
 * Created by gauravwadhwa on 06/03/16.
 */
public class NotificationCenter {

    private Context context;
    private AlarmManager alarmManager;
    private NotificationManager notificationManager;
    private NotificationEventListener listener;

    private static NotificationCenter notificationCenter;

    private NotificationCenter(Context context) {
        this.context = context;
        this.alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        this.notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
    }

    public static NotificationCenter getInstance(Context context) {
        if (notificationCenter == null) {
            notificationCenter = new NotificationCenter(context);
        }
        return notificationCenter;
    }


    public NotificationEventListener getNotificationEventListener() {
        return listener;
    }

    public void show(Notification notification) {
        notificationManager.notify(notification.getId(), notification.build());
    }


}
