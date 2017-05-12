package com.example.samsung.p1191_pendingintent;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private NotificationManager nm;
    private AlarmManager am;
    private Intent intent1, intent2;
    private PendingIntent pendingIntent1, pendingIntent2;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        am = (AlarmManager) getSystemService(ALARM_SERVICE);
    }

    public void onClickBtn(View view) {

        switch (view.getId()) {

            case R.id.btn1:
                intent1 = createIntent(getString(R.string.action_1), getString(R.string.extra_1));
                pendingIntent1 = PendingIntent.getBroadcast(this, 0, intent1, 0);

                intent2 = createIntent(getString(R.string.action_2), getString(R.string.extra_2));
                pendingIntent1 = PendingIntent.getBroadcast(this, 0, intent2, 0);

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
    }

    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    private void sendNotif(final Context context, final int id, final PendingIntent pendingIntent) {
        //Подготовка уведомления в статус-бар
        Notification.Builder builder = new Notification.Builder(context);
        //Установка флага, удаляющего уведомление из списка после нажатия
        builder.setAutoCancel(true);
        //Установка сообщения для статус-бара
        builder.setContentText("Notification's text " + id);
        //Установка стикера
        builder.setTicker("Notification's ticker " + id);
        //Установка заголовка
        builder.setContentTitle("Notification's title " + id);
        //Установка малой иконки
        builder.setSmallIcon(R.mipmap.ic_launcher);
        //Подключение активити к записи
        builder.setContentIntent(pendingIntent);
        builder.setOngoing(true);
        //Только для API не младше №16
//        builder.setSubText("The notification's subtext");
        //Создание строки в разворачивающемся списке уведомлений
        //noinspection deprecation
        Notification notification = builder.getNotification();
        //Отправка уведомления в статус-бар
        nm.notify(1, notification);
    }
}
