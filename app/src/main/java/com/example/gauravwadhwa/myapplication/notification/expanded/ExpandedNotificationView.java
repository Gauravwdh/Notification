package com.example.gauravwadhwa.myapplication.notification.expanded;

import android.content.Context;
import android.widget.RemoteViews;

import com.example.gauravwadhwa.myapplication.notification.NotificationView;

/**
 * Created by gauravwadhwa on 06/03/16.
 */
public class ExpandedNotificationView extends NotificationView {

    public ExpandedNotificationView(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public RemoteViews getRemoteView() {
        return null;
    }

    public class Builder {
    }
}
