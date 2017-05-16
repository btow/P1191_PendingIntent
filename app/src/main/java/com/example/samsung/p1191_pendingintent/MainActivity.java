package com.example.samsung.p1191_pendingintent;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public NotificationManagerCompat nm;
    private AlarmManager am;
    private Intent intent1, intent2;
    private PendingIntent pendingIntent1, pendingIntent2;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nm = NotificationManagerCompat.from(getBaseContext());
        am = (AlarmManager) getSystemService(ALARM_SERVICE);
    }

    public void onClickBtn(View view) {

        switch (view.getId()) {

            case R.id.btn1:
                //PendingIntent Step 1 and AlarmManager Step 11.1
//                intent1 = createIntent(getString(R.string.action_1), getString(R.string.extra_1));
//                pendingIntent1 = PendingIntent.getBroadcast(this, 0, intent1, 0);
//
//                intent2 = createIntent(getString(R.string.action_2), getString(R.string.extra_2));
//                pendingIntent2 = PendingIntent.getBroadcast(this, 0, intent2, 0);
                //PendingIntent Step 2 and AlarmManager Step 11.2
                intent1 = createIntent(getString(R.string.action), getString(R.string.extra_1));
                pendingIntent1 = PendingIntent.getBroadcast(this, 0, intent1, 0);

                intent2 = createIntent(getString(R.string.action), getString(R.string.extra_2));
                pendingIntent2 = PendingIntent.getBroadcast(this, 0, intent2, 0);
                //PendingIntent Step 3
//                intent1 = createIntent(getString(R.string.action_1), getString(R.string.extra_1));
//                pendingIntent1 = PendingIntent.getBroadcast(this, 0, intent1, 0);
//
//                intent2 = createIntent(getString(R.string.action_2), getString(R.string.extra_2));
//                pendingIntent2 = PendingIntent.getBroadcast(this, 0, intent2, 0);
                //PendingIntent Step 4, 8.1, 9.1
//                intent1 = createIntent(getString(R.string.action), getString(R.string.extra_1));
//                pendingIntent1 = PendingIntent.getBroadcast(this, 0, intent1, 0);
                //PendingIntent Step 8.1
//                message = "pendingIntent1 created";
                //PendingIntent Step 10.1
//                intent1 = createIntent(getString(R.string.action), getString(R.string.extra_1));
//                pendingIntent1 = PendingIntent.getBroadcast(this, 1, intent1, 0);
//
//                intent2 = createIntent(getString(R.string.action), getString(R.string.extra_2));
//                pendingIntent2 = PendingIntent.getBroadcast(this, 2, intent2, 0);
                //PendingIntent Step 10.2
//                intent1 = createIntent(getString(R.string.action), getString(R.string.extra_1));
//                Uri data1 = Uri.parse(intent1.toUri(Intent.URI_INTENT_SCHEME));
//                intent1.setData(data1);
//                pendingIntent1 = PendingIntent.getBroadcast(this, 0, intent1, 0);
//
//                intent2 = createIntent(getString(R.string.action), getString(R.string.extra_2));
//                Uri data2 = Uri.parse(intent2.toUri(Intent.URI_INTENT_SCHEME));
//                intent2.setData(data2);
//                pendingIntent2 = PendingIntent.getBroadcast(this, 0, intent2, 0);
                //PendingIntent Step 8 - 10 and AlarmManager Step 11
                message = "pendingIntent1 and pendingIntent2 created";
                Messager.sendToAllRecipients(view.getContext(), message);
                //AlarmManager Step 11
                message = "AlarmManager started";
                Messager.sendToAllRecipients(view.getContext(), message);
                // AlarmManager Step 11.1
//                am.set(AlarmManager.RTC, System.currentTimeMillis() + 4000, pendingIntent1);
//                am.setRepeating(AlarmManager.ELAPSED_REALTIME,
//                        SystemClock.elapsedRealtime() + 3000,
//                        5000, pendingIntent2);
                // AlarmManager Step 11.2
                am.set(AlarmManager.RTC, System.currentTimeMillis() + 2000, pendingIntent1);
                am.set(AlarmManager.RTC, System.currentTimeMillis() + 4000, pendingIntent2);
                //PendingIntent Step 7.2
//                pendingIntent1 = PendingIntent.getBroadcast(this, 0, intent1, PendingIntent.FLAG_ONE_SHOT);

//                intent2 = createIntent(getString(R.string.action), getString(R.string.extra_2));
//                pendingIntent2 = PendingIntent.getBroadcast(this, 0, intent2, 0);
                //PendingIntent Step 5
//                pendingIntent2 = PendingIntent.getBroadcast(this, 0, intent2, PendingIntent.FLAG_CANCEL_CURRENT);
                //PendingIntent Step 6
//                pendingIntent2 = PendingIntent.getBroadcast(this, 0, intent2, PendingIntent.FLAG_UPDATE_CURRENT);

//                compare(view.getContext());
                //PendingIntent Step 3, 9.2, 10
//                sendNotif(view.getContext(), 1, pendingIntent1);
                //PendingIntent Step 3, 10
//                sendNotif(view.getContext(), 2, pendingIntent2);
                //PendingIntent Step 7.1
//                sendNotif(view.getContext(), 2, pendingIntent1);
                break;
            case R.id.btn2 :
                //PendingIntent Step 8.2
//                intent2 = createIntent(getString(R.string.action), getString(R.string.extra_2));
//                pendingIntent2 = PendingIntent.getBroadcast(this, 0, intent2, PendingIntent.FLAG_NO_CREATE);
//                if (pendingIntent2 == null) {
//                    message = "pendingIntent2 is null";
//                } else {
//                    message = "pendingIntent2 created";
//                }
                //PendingIntent Step 9.3 - 10
//                pendingIntent1.cancel();
//                message = "pendingIntent1 is canceled";
//                AlarmManager Step 11
                am.cancel(pendingIntent2);
                message = "AlarmManager of pendingIntent2 is canceled";
                //PendingIntent Step 9.3 - 10 and AlarmManager Step 11
                Messager.sendToAllRecipients(view.getContext(), message);
                break;
            default:
                break;
        }

    }

    private Intent createIntent(final String action, final String extra) {
        Intent intent = new Intent(this, Receiver.class);
        intent.setAction(action);
        intent.putExtra(getString(R.string.extra), extra);
        return intent;
    }

    private void compare(final Context context) {
        message = "intent 1 == intent 2: " + intent1.filterEquals(intent2);
        Messager.sendToAllRecipients(context, message);
        message = "pendingIntent1 == pendingIntent2: " + pendingIntent1.equals(pendingIntent2);
        Messager.sendToAllRecipients(context, message);
    }

    private void sendNotif(final Context context, final int id, final PendingIntent pendingIntent) {
        //Подготовка уведомления в статус-бар
        Notification notification = new NotificationCompat.Builder(context)
                //Установка заголовка
                .setContentTitle("Notification's title " + id)
                //Установка сообщения для статус-бара
                .setContentText("Notification's text " + id)
                //Установка стикера
                .setTicker("Notification's ticker " + id)
                //Установка времени сообщения
                .setWhen(System.currentTimeMillis())
                //Установка малой иконки
                .setSmallIcon(R.mipmap.ic_launcher_round)
                //Подключение активити к записи
                .setContentIntent(pendingIntent)
                //Установка флага, удаляющего уведомление из списка после нажатия
                .setAutoCancel(true)
                //Только для API не младше №16
//              .setSubText("The notification's subtext");
                //Создание строки в разворачивающемся списке уведомлений
                //noinspection deprecation
                .build();
        //Отправка уведомления в статус-бар
        nm.notify(id, notification);
    }
}
