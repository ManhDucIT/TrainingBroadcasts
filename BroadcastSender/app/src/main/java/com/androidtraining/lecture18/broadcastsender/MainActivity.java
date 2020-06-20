package com.androidtraining.lecture18.broadcastsender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String CUSTOM_ACTION_1 = "com.androidtraining.lecture18.broadcastsender.CUSTOM_ACTION_1";
    private static final String CUSTOM_ACTION_2 = "com.androidtraining.lecture18.broadcastsender.CUSTOM_ACTION_2";

    private Button btnSendBroadcast1, btnSendBroadcast2;

    private BR1 br1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btnSendBroadcast1 = findViewById(R.id.btnSendBroadcast1);
        btnSendBroadcast2 = findViewById(R.id.btnSendBroadcast2);

        br1 = new BR1();

        IntentFilter filter = new IntentFilter();
        filter.addAction(CUSTOM_ACTION_1);

        registerReceiver(br1, filter);
    }

    public void onViewClick(View view) {
        switch (view.getId()){
            case R.id.btnSendBroadcast1:
                sendBroadcast1();
                break;

            case R.id.btnSendBroadcast2:
                sendBroadcast2();
                break;
        }
    }

    /**
     * Send explicit broadcast to internal static receiver - BR1
     *
     * NOTE: Only static (manifest registered) receivers can be able to
     * receive broadcast with this sending way
     * (Refer branch: explicit_broadcast_external_all to send explicit broadcast to all receiver types)
     */
    private void sendBroadcast1(){
        // Send Explicit broadcast - Internal without Action
//        Intent intent = new Intent(this, BR1.class);
//        sendBroadcast(intent);

        // Send Explicit broadcast - Internal with Action
        Intent intent = new Intent(this, BR1.class);
        intent.setAction(CUSTOM_ACTION_1);
        sendBroadcast(intent);
    }

    /**
     * Send explicit broadcast to internal dynamic receiver - BR2
     *
     * NOTE: Only static (manifest registered) receivers can be able to
     * receive broadcast with this sending way
     * (Refer branch: explicit_broadcast_external_all to send explicit broadcast to all receiver types)
     */
    private void sendBroadcast2(){
        // Send Explicit broadcast - Internal without Action
//        Intent intent = new Intent(this, BR2.class);
//        sendBroadcast(intent);

        // Send Explicit broadcast - Internal with Action
        Intent intent = new Intent(this, BR2.class);
        intent.setAction(CUSTOM_ACTION_2);
        sendBroadcast(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterReceiver(br1);
    }
}
