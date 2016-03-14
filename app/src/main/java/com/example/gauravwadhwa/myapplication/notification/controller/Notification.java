package com.example.gauravwadhwa.myapplication.notification.controller;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.example.gauravwadhwa.myapplication.notification.ComponentType;
import com.example.gauravwadhwa.myapplication.notification.NotificationView;
import com.example.gauravwadhwa.myapplication.notification.collapse.CollapsedNotificationView;

/**
 * Created by gauravwadhwa on 06/03/16.
 * Class should contain all data about the notification as android notification class contain all the data like pendingIntent, title,
 * content or bitmap or icon everything.
 */
public class Notification {


    public static final int COMPONENT_SERVICE = 1;
    public static final int COMPONENT_ACTIVITY = 2;
    public static final int COMPONENT_BROADCAST_RECEIVER = 3;


    public static final String NOTIFICATION_ID = "notification_id";
    public static final String NOTIFICATION_FLAG = "notification_flag";
    public static final String NOTIFICATION_COMPONENT = "notification_component";

    // todo Required target type: weather it's an activity or br or service to create pendingIntent.
    // or get this info from target intent.

    private CollapsedNotificationView collapsedNotification;
    private NotificationView expandedNotification;

    private Context context;

    // unique notification id.
    private int id;
    // flag for unique notification or can be used as a category.
    private int flag;
    // drawable icon
    private int icon;
    // default 0 and wont be used. But if not 0 then notification removed after this time.
    private long expiryTime;

    private void setTargetIntent(Intent intent) {
        intent.putExtra(NOTIFICATION_ID, id);
        intent.putExtra(NOTIFICATION_FLAG, flag);
    }

    public int getId() {
        return id;
    }

    public int getFlag() {
        return flag;
    }

    public int getIcon() {
        return icon;
    }

    public long getExpiryTime() {
        return expiryTime;
    }

    public CollapsedNotificationView getCollapsedNotification() {
        return collapsedNotification;
    }

    public NotificationView getExpandedNotification() {
        return expandedNotification;
    }

    protected android.app.Notification build() {
        return null;
    }

    public class Builder {
        private CollapsedNotificationView collapsedNotification;
        private NotificationView expandedNotification;
        // class and data.
        private Intent targetIntent;
        // unique notification id.
        private int id;
        // flag for unique notification or can be used as a category.
        private int flag;
        // default 0 and wont be used. But if not 0 then notification removed after this time.
        private long expiryTime;


        public void setExpandedNotification(NotificationView expandedNotification) {
            this.expandedNotification = expandedNotification;
        }

        public void setTargetIntent(Intent targetIntent) {
            this.targetIntent = targetIntent;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setFlag(int flag) {
            this.flag = flag;
        }

        public void setExpiryTime(long expiryTime) {
            this.expiryTime = expiryTime;
        }

        public Notification build() {
            Notification notification = new Notification();
//            if (collapsedNotification == null) {
//                throw new NoNotificationViewException();
//            }
            notification.collapsedNotification = collapsedNotification;
            notification.expandedNotification = expandedNotification;
            notification.id = id;
            notification.flag = flag;
            notification.expiryTime = expiryTime;
            notification.setTargetIntent(targetIntent);
            return notification;
        }
    }


    public static PendingIntent getBroadcastReceiver(Context context, int notificationId, Intent intent, int flag) {
        return getPendingIntent(context, notificationId, intent, flag, COMPONENT_BROADCAST_RECEIVER);
    }

    public static PendingIntent getActivity(Context context, int notificationId, Intent intent, int flag) {
        return getPendingIntent(context, notificationId, intent, flag, COMPONENT_ACTIVITY);
    }

    public static PendingIntent getService(Context context, int notificationId, Intent intent, int flag) {
        return getPendingIntent(context, notificationId, intent, flag, COMPONENT_SERVICE);
    }

    private static PendingIntent getPendingIntent(Context context, int notificationId,
                                                  Intent intent, int flag, @ComponentType int componentType) {
        intent.putExtra(NOTIFICATION_ID, notificationId);
        intent.putExtra(NOTIFICATION_FLAG, flag);
        intent.putExtra(NOTIFICATION_COMPONENT, componentType);
        return PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
    }
}
