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
public class TextNotification extends CollapsedNotificationView {

    private RemoteViews remoteViews;

    public TextNotification(@NonNull Context context) {
        super(context);
        remoteViews = new RemoteViews(context.getPackageName(), R.layout.small_text_notification);
        builder.setContent(remoteViews);
    }

    public TextNotification setTitle(String title) {
        RemoteViewUtil.setText(remoteViews, R.id.title, title);
        return this;
    }

    public TextNotification setContent(String content) {
        RemoteViewUtil.setText(remoteViews, R.id.content, content);
        return this;
    }

    public TextNotification setTime(String time) {
        RemoteViewUtil.setText(remoteViews, R.id.time, time);
        return this;
    }

    public TextNotification setTime(long time) {
        RemoteViewUtil.setText(remoteViews, R.id.time, Util.formatTime(time, Util.TIME_HH_MM_AA));
        return this;
    }

    public TextNotification setIcon(int icon) {
        builder.setSmallIcon(icon);
        return this;
    }

}
