package com.androidtraining.lecture18;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class ExampleReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // Intent is the object sent by system or other apps
        String action = intent.getAction();

        if(Intent.ACTION_POWER_CONNECTED.equals(action)){
            Toast.makeText(context, "Power connected", Toast.LENGTH_SHORT).show();
        }
        else if(Intent.ACTION_POWER_DISCONNECTED.equals(action)){
            Toast.makeText(context, "Power disconnected", Toast.LENGTH_SHORT).show();
        }
        else if(ConnectivityManager.CONNECTIVITY_ACTION.equals(action)){
            boolean isNoConnectivity = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);

            String message = "Internet available";

            if(isNoConnectivity){
                message = "No internet connection";
            }

            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        }
        else if(intent.getAction().equals(Intent.ACTION_HEADSET_PLUG)){
            int state = intent.getIntExtra("state", -1);

            switch (state) {
                case 0:
                    Toast.makeText(context, "Headset unplugged", Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    Toast.makeText(context, "Headset plugged", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    Toast.makeText(context, "Headset ", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
