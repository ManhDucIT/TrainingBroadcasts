package com.androidtraining.lecture18;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements IConnectivityListener {

    private TextView tvConnectivityStatus;
    private ExampleReceiver exampleReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        tvConnectivityStatus = findViewById(R.id.tvConnectivityStatus);

        exampleReceiver = new ExampleReceiver(this);

        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction(Intent.ACTION_HEADSET_PLUG);

        registerReceiver(exampleReceiver, filter);
    }

    @Override
    public void onConnectivityChanged(boolean isNetworkAvailable) {
        tvConnectivityStatus.setText(isNetworkAvailable ? "Network available" : "Waiting for network");
        tvConnectivityStatus.setTextColor(isNetworkAvailable ? getResources().getColor(android.R.color.holo_green_dark) : getResources().getColor(android.R.color.holo_orange_dark));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterReceiver(exampleReceiver);
    }

}
