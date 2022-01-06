package com.example.notification;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    String CHANNEL_ID = "MISC";
    NotificationCompat.Builder builder;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Sample")
                .setContentText("This is a sample notification")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        //Create the notification channel
        String name = "FunChannel";
        String desc = "FunDesc";
        int imp = NotificationManager.IMPORTANCE_DEFAULT;
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, imp);
        channel.setDescription(desc);
        NotificationManager notifman = getSystemService(NotificationManager.class);
        notifman.createNotificationChannel(channel);

    }

    public void onClick(View v) {
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(1, builder.build());

    }
}