package com.example.quizapp

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class RemainderBroadcast : BroadcastReceiver() {

    @SuppressLint("MissingPermission")
    override fun onReceive(context: Context?, intent: Intent?) {
        // Create an intent to open the application
        val openAppIntent = Intent(context, MainActivity::class.java)
        openAppIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

        // Create a PendingIntent to open the application
        val pendingIntent = PendingIntent.getActivity(context, 0, openAppIntent, PendingIntent.FLAG_UPDATE_CURRENT)

        // Create the notification channel (required for Android 8.0 and above)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = "channel_id"
            val channelName = "Channel Name"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(channelId, channelName, importance)
            val notificationManager = context?.getSystemService(NotificationManager::class.java)
            notificationManager?.createNotificationChannel(channel)
        }

        // Create the notification
        val notification = NotificationCompat.Builder(context!!, "channel_id")
            .setContentTitle("Don't lose your work!")
            //.setStyle(NotificationCompat.BigTextStyle().bigText("Remember to connect to the internet and sync all offline drafts before they're gone."))
            .setContentText("Remember to connect to the internet and sync all offline drafts before they're gone.")
            .setStyle(NotificationCompat.BigTextStyle()
                .bigText("Remember to connect to the internet and sync all offline drafts before they're gone."))
            //.setContentText("Remember to connect to the internet and sync all offline drafts before they're gone.")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()

        // Display the notification
        val notificationManager = NotificationManagerCompat.from(context)
        notificationManager.notify(0, notification)
    }
}
