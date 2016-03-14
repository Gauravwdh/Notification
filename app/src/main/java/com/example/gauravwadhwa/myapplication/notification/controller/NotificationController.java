package com.example.gauravwadhwa.myapplication.notification.controller;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.gauravwadhwa.myapplication.notification.Logger;
import com.example.gauravwadhwa.myapplication.notification.NotificationEventListener;

/**
 * Created by gauravwadhwa on 14/03/16.
 * <p>
 * This Broadcast receiver will act as a controller and pass every click/swipe/exipry throw a appropriate flow.
 * It will be called on any action of the notification.
 * Also it will call the provide callback on {@link NotificationEventListener}
 */
public class NotificationController extends BroadcastReceiver {

    private static final String TAG = NotificationController.class.getName();


    public static final String NOTIFICATION_ACTION = "notification_action";

    /**
     * Handle by the intent.
     */
    public static final String NOTIFICATION_CLICKED = "notification_clicked";
    /**
     * Will be handled by the framework on external handling.
     */
    public static final String NOTIFICATION_SWIPED = "notification_swiped";
    /**
     * Will be handled by the framework on external handling.
     */
    public static final String NOTIFICATION_EXPIRED = "notification_expired";
    /**
     * Will be handled by intent provided.
     */
    public static final String NOTIFICATION_CTA_CLICKED = "notification_cta_clicked";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (!intent.hasExtra(NOTIFICATION_ACTION)) {
            debug("Action type is null");
            return;
        }
        NotificationEventListener notificationEventListener = NotificationCenter.getInstance(context).getNotificationEventListener();

        String action = intent.getStringExtra(NOTIFICATION_ACTION);
        int notificationId = intent.getIntExtra(Notification.NOTIFICATION_ID, -1);
        int notificationFlag = intent.getIntExtra(Notification.NOTIFICATION_FLAG, -1);
        int componentType = intent.getIntExtra(Notification.NOTIFICATION_COMPONENT, Notification.COMPONENT_ACTIVITY);

        switch (action) {
            case NOTIFICATION_CLICKED:
                if (notificationEventListener != null) {
                    notificationEventListener.onNotificationClicked(notificationId, notificationFlag, intent);
                }
                handleClick(context, componentType, intent);
                break;
            case NOTIFICATION_SWIPED:
                if (notificationEventListener != null) {
                    notificationEventListener.onNotificationSwiped(notificationId, notificationFlag, intent);
                }
                handleSwipe(context, componentType, intent);
                break;
            case NOTIFICATION_EXPIRED:
                if (notificationEventListener != null) {
                    notificationEventListener.onNotificationExpired(notificationId, notificationFlag, intent);
                }
                handleExpiry(context, componentType, intent);
                break;
            case NOTIFICATION_CTA_CLICKED:
                if (notificationEventListener != null) {
                    notificationEventListener.onNotificationCtaClicked(notificationId, notificationFlag, intent);
                }
                handleClick(context, componentType, intent);
                break;
        }
        clearNotification(context, notificationId);
    }

    private void handleExpiry(Context context, int componentType, Intent intent) {
        // todo
    }

    private void handleSwipe(Context context, int componentType, Intent intent) {
        //todo
    }


    private void clearNotification(Context context, int notificationId) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancel(notificationId);
    }


    private void handleClick(Context context, int componentType, Intent intent) {
        switch (componentType) {
            case Notification.COMPONENT_ACTIVITY:
                openActivity(context, intent);
                break;
            case Notification.COMPONENT_SERVICE:
                startService(context, intent);
                break;
            case Notification.COMPONENT_BROADCAST_RECEIVER:
                startBroadcastReceiver(context, intent);
                break;
        }
    }

    private static void openActivity(Context context, Intent intent) {
        context.startActivity(intent);
    }

    private static void startService(Context context, Intent intent) {
        context.startService(intent);
    }

    private static void startBroadcastReceiver(Context context, Intent intent) {
        context.sendBroadcast(intent);
    }


    private static void debug(Object object) {
        Logger.log(TAG, object);
    }
}
