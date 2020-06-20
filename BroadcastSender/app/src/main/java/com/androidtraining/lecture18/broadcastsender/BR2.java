package com.androidtraining.lecture18.broadcastsender;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class BR2 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if("com.androidtraining.lecture18.broadcastsender.CUSTOM_ACTION_2".equals(action)){
            Log.i("CUSTOM BROADCAST", "BR2 with action");
        }
        else {
            Log.i("CUSTOM BROADCAST", "BR2");
        }
    }

}
