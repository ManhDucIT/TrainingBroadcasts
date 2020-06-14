package com.androidtraining.lecture18;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ExampleBroadcastReceiver exampleBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        exampleBroadcastReceiver = new ExampleBroadcastReceiver();

        IntentFilter filter = new IntentFilter();
        filter.addAction("com.androidtraining.lecture18.broadcastsender.CUSTOM_ACTION_1");

        registerReceiver(exampleBroadcastReceiver, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterReceiver(exampleBroadcastReceiver);
    }
}
