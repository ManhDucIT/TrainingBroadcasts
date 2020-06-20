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
        String action = intent.getAction();

        if("com.androidtraining.lecture18.broadcastsender.CUSTOM_ACTION_1".equals(action)){
            Log.i("CUSTOM BROADCAST", "BR1");

            int resultCode = getResultCode();
            String resultData = getResultData();
            Bundle resultExtras = getResultExtras(true);
            String stringExtra = resultExtras.getString("stringExtra");

            resultCode++;
            stringExtra += "->OR1";

            String description = "OR1\n" +
                    "resultCode: " + resultCode + "\n" +
                    "resultData: " + resultData + "\n" +
                    "stringExtra: " + stringExtra;

            Log.i("CUSTOM BROADCAST", description);

            resultData = "OR1";
            resultExtras.putString("stringExtra", stringExtra);

            setResult(resultCode, resultData, resultExtras);
        }
    }

}
