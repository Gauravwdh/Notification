package com.example.gauravwadhwa.myapplication.notification.util;

import android.text.TextUtils;
import android.view.View;
import android.widget.RemoteViews;

/**
 * Created by gauravwadhwa on 15/03/16.
 */
public class RemoteViewUtil {


    public static void setText(RemoteViews remoteViews, int viewId, String text) {
        if (TextUtils.isEmpty(text)) {
            remoteViews.setViewVisibility(viewId, View.GONE);
        } else {
            remoteViews.setViewVisibility(viewId, View.VISIBLE);
            remoteViews.setTextViewText(viewId, text);
        }
    }


}
