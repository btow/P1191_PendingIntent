package com.example.samsung.p1191_pendingintent;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
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
                //Step 1
//                intent1 = createIntent(getString(R.string.action_1), getString(R.string.extra_1));
//                pendingIntent1 = PendingIntent.getBroadcast(this, 0, intent1, 0);
//
//                intent2 = createIntent(getString(R.string.action_2), getString(R.string.extra_2));
//                pendingIntent2 = PendingIntent.getBroadcast(this, 0, intent2, 0);
                //Step 2
//                intent1 = createIntent(getString(R.string.action), getString(R.string.extra_1));
//                pendingIntent1 = PendingIntent.getBroadcast(this, 0, intent1, 0);
//
//                intent2 = createIntent(getString(R.string.action), getString(R.string.extra_2));
//                pendingIntent2 = PendingIntent.getBroadcast(this, 0, intent2, 0);
                //Step 3
//                intent1 = createIntent(getString(R.string.action_1), getString(R.string.extra_1));
//                pendingIntent1 = PendingIntent.getBroadcast(this, 0, intent1, 0);
//
//                intent2 = createIntent(getString(R.string.action_2), getString(R.string.extra_2));
//                pendingIntent2 = PendingIntent.getBroadcast(this, 0, intent2, 0);
                //Step 4
                intent1 = createIntent(getString(R.string.action), getString(R.string.extra_1));
                pendingIntent1 = PendingIntent.getBroadcast(this, 0, intent1, 0);

                intent2 = createIntent(getString(R.string.action), getString(R.string.extra_2));
                pendingIntent2 = PendingIntent.getBroadcast(this, 0, intent2, 0);

                compare(view.getContext());
                //Step 3
                sendNotif(view.getContext(), 1, pendingIntent1);
                sendNotif(view.getContext(), 2, pendingIntent2);
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
