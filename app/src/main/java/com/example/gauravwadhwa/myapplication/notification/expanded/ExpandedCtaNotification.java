package com.example.gauravwadhwa.myapplication.notification.expanded;

import android.content.Context;

import com.example.gauravwadhwa.myapplication.notification.ButtonCallToAction;

/**
 * Created by gauravwadhwa on 14/03/16.
 */
public class ExpandedCtaNotification extends ExpandedNotificationView {


    public ExpandedCtaNotification(Context context, int layoutId) {
        super(context, layoutId);
    }


    /**
     * Max 3 call to actions are supported.
     *
     * @param callToAction
     */
    public void setCallToAction(ButtonCallToAction[] callToAction) {

    }
}
