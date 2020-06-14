package com.androidtraining.lecture18;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ExampleReceiver exampleReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        exampleReceiver = new ExampleReceiver();

        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction(Intent.ACTION_HEADSET_PLUG);

        registerReceiver(exampleReceiver, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterReceiver(exampleReceiver);
    }
}
