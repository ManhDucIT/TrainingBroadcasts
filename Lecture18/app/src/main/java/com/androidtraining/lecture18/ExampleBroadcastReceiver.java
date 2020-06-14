package com.androidtraining.lecture18;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ExampleBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if ("com.androidtraining.lecture18.broadcastsender.CUSTOM_ACTION_1".equals(action)){
            String data = intent.getStringExtra("DATA");

            Toast.makeText(context, "Custom broadcast: " + (data != null ? data : ""), Toast.LENGTH_SHORT).show();
        }
    }

}
