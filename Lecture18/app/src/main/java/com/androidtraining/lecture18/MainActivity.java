package com.androidtraining.lecture18;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private BR1 br1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        br1 = new BR1();

        IntentFilter filter = new IntentFilter("com.androidtraining.lecture18.broadcastsender.CUSTOM_ACTION_1");
        filter.setPriority(1);

        registerReceiver(br1, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterReceiver(br1);
    }
}
