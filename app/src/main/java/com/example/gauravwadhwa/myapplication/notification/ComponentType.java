package com.example.gauravwadhwa.myapplication.notification;

import android.support.annotation.IntDef;

import com.example.gauravwadhwa.myapplication.notification.controller.Notification;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef({
        Notification.COMPONENT_SERVICE,
        Notification.COMPONENT_ACTIVITY,
        Notification.COMPONENT_BROADCAST_RECEIVER
})
@Retention(RetentionPolicy.SOURCE)
public @interface ComponentType {
}
