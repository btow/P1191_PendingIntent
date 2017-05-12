package com.example.samsung.p1191_pendingintent;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by samsung on 12.05.2017.
 */

public class Messager {

    private final static String LOG_TAG = "myLogs";

    public static final void sendToAllRecipients(final Context context, final String message) {
        Log.d(LOG_TAG, message);
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static final void sendToOnlyLog(final String message) {
        Log.d(LOG_TAG, message);
    }
}
