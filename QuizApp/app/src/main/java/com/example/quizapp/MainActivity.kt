package com.example.quizapp

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonStart : Button = findViewById(R.id.buttonStart)
        val nameBox : EditText = findViewById(R.id.et_name)

        buttonStart.setOnClickListener {
            if (nameBox.text.isNotEmpty()) {
                val intent = Intent(this, QuizQuestionsActivity::class.java)
                startActivity(intent)
                nameBox.text.clear()
            } else {
                nameBox.error = "You need to enter a name"
                //Toast.makeText(this, "Please enter your name", Toast.LENGTH_LONG).show()
            }
        }
//        createNotificationChannel()
        setAlarm()
    }

//    @SuppressLint("ServiceCast")
//    private fun setAlarm() {
//
//        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
//
//        val intent = Intent(this, RemainderBroadcast::class.java)
//
//        val pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
//
//        // Set the alarm using the AlarmManager
//        // Specify the desired alarm time (in milliseconds) using System.currentTimeMillis() + desiredDelay
//        // Here, we set the alarm to go off after 5 seconds
//        val desiredDelay = 5000
//        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + desiredDelay, pendingIntent)
//    }

    private fun setAlarm() {
        // Get the desired notification time
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, 10) // Set the hour of day (in 24-hour format)
        calendar.set(Calendar.MINUTE, 0) // Set the minute

        // Create an instance of AlarmManager
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager

        // Create an intent for the RemainderBroadcast class
        val intent = Intent(
            this,
            com.example.quizapp.RemainderBroadcast::class.java
        )

        val pendingIntent = PendingIntent.getBroadcast(
            this,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

         //Set the alarm using the AlarmManager
         //Use setInexactRepeating if you want to repeat the notification at the same time every day
         //Use setExact if you want the notification to be triggered exactly at the specified time
        alarmManager.setInexactRepeating(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            AlarmManager.INTERVAL_DAY,
            pendingIntent
        )
//        alarmManager.setRepeating(
//            AlarmManager.RTC_WAKEUP,
//            calendar.timeInMillis,
//            AlarmManager.INTERVAL_FIFTEEN_MINUTES,
//            pendingIntent
//        )

    }
}