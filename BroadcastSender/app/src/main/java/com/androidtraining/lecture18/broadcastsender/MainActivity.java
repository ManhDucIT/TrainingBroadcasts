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

    private Button btnSendBroadcast1, btnSendBroadcast2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btnSendBroadcast1 = findViewById(R.id.btnSendBroadcast1);
        btnSendBroadcast2 = findViewById(R.id.btnSendBroadcast2);
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
     * Send explicit broadcast to external apps and already know target
     */
    private void sendBroadcast1(){
        // Explicit broadcast - External
        Intent intent = new Intent();

        // Method 1:
        ComponentName componentName = new ComponentName("com.androidtraining.lecture18", "com.androidtraining.lecture18.ExampleBroadcastReceiver");
        intent.setComponent(componentName);

        // Method 2:
//        intent.setClassName("com.androidtraining.lecture18", "com.androidtraining.lecture18.ExampleBroadcastReceiver");

        intent.setAction(CUSTOM_ACTION_1);
        sendBroadcast(intent);
    }

    /**
     * Send explicit broadcast to external apps but don't know target
     */
    private void sendBroadcast2(){
        // Explicit broadcast - External with Auto-query (only manifest receivers will receive the broadcast)
        Intent intent = new Intent(CUSTOM_ACTION_1);
        List<ResolveInfo> info = getPackageManager().queryBroadcastReceivers(intent, 0);

        for(ResolveInfo item : info){
            ComponentName cp = new ComponentName(item.activityInfo.packageName, item.activityInfo.name);
            intent.setComponent(cp);
            sendBroadcast(intent);
        }
    }
}
