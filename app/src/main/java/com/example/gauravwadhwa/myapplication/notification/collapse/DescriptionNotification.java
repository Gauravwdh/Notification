package com.example.gauravwadhwa.myapplication.notification.collapse;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.RemoteViews;

import com.example.gauravwadhwa.myapplication.R;
import com.example.gauravwadhwa.myapplication.notification.util.RemoteViewUtil;
import com.example.gauravwadhwa.myapplication.notification.util.Util;

/**
 * Created by gauravwadhwa on 06/03/16.
 */
public class DescriptionNotification extends CollapsedNotificationView {

    private RemoteViews remoteViews;

    public DescriptionNotification(@NonNull Context context) {
        super(context);
        remoteViews = new RemoteViews(context.getPackageName(), R.layout.small_desciption_notification);
        builder.setContent(remoteViews);
    }


    public DescriptionNotification setContent(String content) {
        RemoteViewUtil.setText(remoteViews, R.id.content, content);
        return this;
    }

    public DescriptionNotification setTime(String time) {
        RemoteViewUtil.setText(remoteViews, R.id.time, time);
        return this;
    }

    public DescriptionNotification setTime(long time) {
        RemoteViewUtil.setText(remoteViews, R.id.time, Util.formatTime(time, Util.TIME_HH_MM_AA));
        return this;
    }

    public DescriptionNotification setIcon(int icon) {
        builder.setSmallIcon(icon);
        return this;
    }

}
