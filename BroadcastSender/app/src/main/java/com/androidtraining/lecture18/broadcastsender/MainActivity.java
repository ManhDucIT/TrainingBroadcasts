package com.androidtraining.lecture18.broadcastsender;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final int SMS_PERMISSION_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        if (!hasReadSmsPermission()) {
            requestReadAndSendSmsPermission();
        }
    }

    private boolean hasReadSmsPermission() {
        return ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.RECEIVE_SMS) == PackageManager.PERMISSION_GRANTED;
    }

    private void requestReadAndSendSmsPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.RECEIVE_SMS)) {
            return;
        }

        ActivityCompat.requestPermissions(MainActivity.this, new String[]{ Manifest.permission.RECEIVE_SMS }, SMS_PERMISSION_CODE);
    }
}
