package com.example.gauravwadhwa.myapplication.notification;

import android.content.Intent;

/**
 * Created by gauravwadhwa on 14/03/16.
 */
public class ButtonCallToAction extends CallToAction {

    public static final int NO_DRAWABLE = -1;

    public String text;
    public int drawable;

    public ButtonCallToAction(@ComponentType int componentType, String text, Intent intent) {
        this(componentType, NO_DRAWABLE, text, intent);
    }

    public ButtonCallToAction(@ComponentType int componentType, int drawable, String text, Intent intent) {
        super(componentType, intent);
        this.drawable = drawable;
        this.text = text;
    }
}
