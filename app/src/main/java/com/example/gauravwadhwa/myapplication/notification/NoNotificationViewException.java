package com.example.gauravwadhwa.myapplication.notification;

/**
 * Created by gauravwadhwa on 06/03/16.
 */
public class NoNotificationViewException extends Exception {

    public NoNotificationViewException() {
        super("No View for the notification.");
    }
}
