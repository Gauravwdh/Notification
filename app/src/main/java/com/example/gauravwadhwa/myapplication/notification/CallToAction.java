package com.example.gauravwadhwa.myapplication.notification;

import android.content.Intent;

public class CallToAction {

    public final int componentType;
    public final Intent intent;

    public CallToAction(@ComponentType int componentType, Intent intent) {
        this.componentType = componentType;
        this.intent = intent;
    }

}