package com.example.samsung.p1191_pendingintent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by samsung on 12.05.2017.
 */

public class Receiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String message = context.getString(R.string.receiver)
                + " " + context.getString(R.string.on_receive);
        Messager.sendToAllRecipients(context, message);
        message = context.getString(R.string.action_) + intent.getAction();
        Messager.sendToAllRecipients(context, message);
        message = context.getString(R.string.extra_)
                + intent.getStringExtra(context.getString(R.string.extra));
        Messager.sendToAllRecipients(context, message);
    }
}
