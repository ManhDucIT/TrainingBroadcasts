package com.androidtraining.lecture18;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class BR1 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("CUSTOM BROADCAST", "BR1");

        int resultCode = getResultCode();
        String resultData = getResultData();
        Bundle resultExtras = getResultExtras(true);
        String stringExtra = resultExtras.getString("stringExtra");
        resultCode++;
        stringExtra += "->OR1";
        String toastText = "OR1\n" +
                "resultCode: " + resultCode + "\n" +
                "resultData: " + resultData + "\n" +
                "stringExtra: " + stringExtra;
        Toast.makeText(context, toastText, Toast.LENGTH_LONG).show();
        resultData = "OR1";
        resultExtras.putString("stringExtra", stringExtra);
        setResult(resultCode, resultData, resultExtras);
    }

}
