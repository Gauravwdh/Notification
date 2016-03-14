package com.example.gauravwadhwa.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.gauravwadhwa.myapplication.notification.collapse.DescriptionNotification;

/**
 * Created by gauravwadhwa on 17/08/15.
 */
public class CustomTextView extends TextView {

    private static final String ATTR_TYPEFACE = "typeface";

    public static final String TYPEFACE_REGULAR = "regular";
    public static final String TYPEFACE_SEMI_BOLD = "semi_bold";
    public static final String TYPEFACE_LIGHT = "light";


    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        String typeFace = attrs.getAttributeValue(null, ATTR_TYPEFACE);
        setTypeface(typeFace);
    }

    public void setTypeface(String typeFace) {
        if (typeFace == null) {
            return;
        }
        switch (typeFace) {
            case TYPEFACE_REGULAR:
                Log.e("tag","1");
                break;
            case TYPEFACE_SEMI_BOLD:
                Log.e("tag","2");
                break;
            case TYPEFACE_LIGHT:
                Log.e("tag","3");
                break;
        }
    }
}
