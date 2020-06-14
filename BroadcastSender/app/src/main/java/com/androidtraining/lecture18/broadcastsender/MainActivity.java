package com.androidtraining.lecture18.broadcastsender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

    private void sendBroadcast(){
        Intent intent = new Intent();
        intent.setAction(CUSTOM_ACTION_1);
        intent.putExtra("DATA", "Hello");
        sendBroadcast(intent);
    }

}
