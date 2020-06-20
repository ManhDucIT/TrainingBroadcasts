package com.androidtraining.lecture18.broadcastsender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String CUSTOM_ACTION_1 = "com.androidtraining.lecture18.broadcastsender.CUSTOM_ACTION_1";

    private Button btnSendBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btnSendBroadcast = findViewById(R.id.btnSendBroadcast);
    }

    public void onViewClick(View view) {
        switch (view.getId()){
            case R.id.btnSendBroadcast:
                sendBroadcast();
                break;
        }
    }

    /**
     * Send an order broadcast to all external receivers
     *
     * NOTE: The order that receivers will receive the broadcast depends on their defined priority
     * Higher priority receiver will receive the broadcast first and can be able to determine if
     * other lower priority broadcast can receive this broadcast or not
     */
    private void sendBroadcast(){
        Intent intent = new Intent(CUSTOM_ACTION_1);

        intent.setPackage("com.androidtraining.lecture18");

        Bundle extras = new Bundle();
        extras.putString("stringExtra", "Start");

        sendOrderedBroadcast(intent, null, null, null, 0, "Start", extras);
    }
}