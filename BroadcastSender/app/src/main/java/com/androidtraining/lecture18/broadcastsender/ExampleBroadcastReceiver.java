package com.androidtraining.lecture18.broadcastsender;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.widget.Toast;

public class ExampleBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Telephony.Sms.Intents.SMS_RECEIVED_ACTION)){
            Toast.makeText(context, "New message received", Toast.LENGTH_SHORT).show();
        }
    }

}
