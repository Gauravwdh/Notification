package com.example.gauravwadhwa.myapplication.notification.collapse;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;

/**
 * Created by gauravwadhwa on 06/03/16.
 * Will contain all the data about that small notification.
 * Base class for the smallNotificationView.
 */
public abstract class CollapsedNotificationView {

    protected final NotificationCompat.Builder builder;

    public CollapsedNotificationView(@NonNull Context context) {
        builder = new NotificationCompat.Builder(context);
    }

    public final NotificationCompat.Builder getNotificationBuilder() {
        return builder;
    }


}
