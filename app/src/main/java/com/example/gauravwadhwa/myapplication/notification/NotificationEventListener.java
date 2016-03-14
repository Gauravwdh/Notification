package com.example.gauravwadhwa.myapplication.notification;

import android.content.Intent;

/**
 * Created by gauravwadhwa on 06/03/16.
 */
public interface NotificationEventListener {

    public void onNotificationClicked(int id, int flag, Intent intent);

    public void onNotificationSwiped(int id, int flag, Intent intent);

    public void onNotificationExpired(int id, int flag, Intent intent);

    // looking 4 it.
    public void onNotificationCtaClicked(int id, int flag, Intent intent);

}
