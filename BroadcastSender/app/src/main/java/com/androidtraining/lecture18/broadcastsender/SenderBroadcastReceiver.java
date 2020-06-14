package com.androidtraining.lecture18.broadcastsender;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class SenderBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if("com.androidtraining.lecture18.broadcastsender.CUSTOM_ACTION_1".equals(action)){
            Toast.makeText(context, "Explicit broadcast with action received", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "Explicit broadcast received", Toast.LENGTH_SHORT).show();
        }
    }

}