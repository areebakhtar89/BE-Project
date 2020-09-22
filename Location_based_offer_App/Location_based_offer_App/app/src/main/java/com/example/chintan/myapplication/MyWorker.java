package com.example.chintan.myapplication;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.chintan.myapplication.ConnectionM.Connection;

import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import static android.content.ContentValues.TAG;


public class MyWorker extends Worker {
    public static final String KEY_TASK_OUTPUT = "key_task_output";
    int resp;
    public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);

    }
    @NonNull
    @Override
    public Result doWork() {
        final String email="xyz@gmail.com";
        final String pass="1234";

        try {
            final Connection conn = new Connection();
            int i = conn.authUser(getApplicationContext(),email, pass);
            resp = i;
            if (resp==1)
            {
                displayNotification("hello sir","hi");

            }

            return Result.SUCCESS;


        }
        catch(Exception e)
        {
           return Result.FAILURE;
        }



/*
        Data data = getInputData();
        String desc = data.getString(MainActivity.KEY_TASK_DESC);
        displayNotification("Hey I am your work", desc);


        Data data1 = new Data.Builder()
                .putString(KEY_TASK_OUTPUT, "Task Finished Successfully")
                .build();

        setOutputData(data1);*/


    }

    private void displayNotification(String task, String desc) {
        int NOTIFICATION_ID = 1;

        NotificationManager manager =
                (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

        Intent notificationIntent = new Intent(getApplicationContext(),ViewofferlistActivity.class);

        PendingIntent notificationPendingIntent = PendingIntent.getActivity(getApplicationContext(), NOTIFICATION_ID,
                notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("simplifiedcoding", "simplifiedcoding", NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(channel);
        }
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), "simplifiedcoding")
                .setContentTitle(task)
                .setContentText(desc)
                .setContentIntent(notificationPendingIntent)
                .setSound(alarmSound)
                .setAutoCancel(true)
                .setSmallIcon(R.mipmap.ic_launcher);


        manager.notify(1, builder.build());

    }
}
