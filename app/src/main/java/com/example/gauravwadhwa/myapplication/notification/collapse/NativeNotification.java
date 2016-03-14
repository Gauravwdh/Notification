package com.example.gauravwadhwa.myapplication.notification.collapse;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Created by gauravwadhwa on 09/03/16.
 */
public class NativeNotification extends CollapsedNotificationView {

    public NativeNotification(@NonNull Context context) {
        super(context);
    }

    public void setTitle(String title) {
        builder.setContentTitle(title);
    }

    public void setContentText(String content) {
        builder.setContentText(content);
    }

    public void setIcon(int icon) {
        builder.setSmallIcon(icon);
    }

}
