package com.example.joannahulek.cyanmusicplayer.listeners;

import android.content.Context;
import android.content.Intent;
import android.view.View;

/**
 * Created by Joasia on 24.05.2017.
 */

public class OnClickChangeIntentListener implements View.OnClickListener {
    private final Context context;
    private final Class<?> targetClass;
    private final Class<?> previousScreenClass;

    public OnClickChangeIntentListener(Context context,
                                       Class<?> targetClass,
                                       Class<?> previousScreenClass) {
        this.context = context;
        this.targetClass = targetClass;
        this.previousScreenClass = previousScreenClass;
    }

    public OnClickChangeIntentListener(Context context,
                                       Class<?> targetClass) {
        this.context = context;
        this.targetClass = targetClass;
        this.previousScreenClass = null;
    }


    @Override
    public void onClick(View v) {
        Intent i = new Intent(context, targetClass);
        if (previousScreenClass!=null) {
            i.putExtra("previousScreen", previousScreenClass);
        }
        context.startActivity(i);

    }
}