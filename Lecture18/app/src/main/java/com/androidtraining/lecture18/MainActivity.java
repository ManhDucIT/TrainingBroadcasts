package com.androidtraining.lecture18;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ExampleBroadcastReceiver2 exampleBroadcastReceiver2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        exampleBroadcastReceiver2 = new ExampleBroadcastReceiver2();

        IntentFilter filter = new IntentFilter();
        filter.addAction("com.androidtraining.lecture18.broadcastsender.CUSTOM_ACTION_1");

        registerReceiver(exampleBroadcastReceiver2, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterReceiver(exampleBroadcastReceiver2);
    }
}
