package com.android.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    NotificationManager manager;
    Notification myNotication;
    int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void generateNotification(View view){

        manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        Intent intent = new Intent();
        intent.setComponent(new ComponentName(getApplicationContext(), MainActivity.class));
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),0, intent, 0);

        Notification.Builder builder = new Notification.Builder(MainActivity.this);

        builder.setAutoCancel(true);
        builder.setTicker("this is ticker text");
        builder.setContentTitle("Test Notification");
        builder.setContentText("You have a new message");
        builder.setSmallIcon(R.drawable.hand);
        builder.setContentIntent(pendingIntent);
        builder.setOngoing(false);
        //builder.setSubText("This is subtext...");   //API level 16
        //builder.setNumber(100);
        builder.build();

        myNotication = builder.getNotification();
        manager.notify(count++, myNotication);

    }
}
