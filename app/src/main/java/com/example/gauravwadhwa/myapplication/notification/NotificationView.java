package com.example.gauravwadhwa.myapplication.notification;

import android.content.Context;
import android.widget.RemoteViews;

/**
 * Created by gauravwadhwa on 06/03/16.
 */
public class NotificationView {

    protected RemoteViews remoteViews;

    public NotificationView(Context context, int layoutId) {
        remoteViews = new RemoteViews(context.getPackageName(), layoutId);
    }


    public RemoteViews getRemoteView() {
        return remoteViews;
    }
}
