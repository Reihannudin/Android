package com.mvvm.Journey

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_notification.*

class NotificationActivity: AppCompatActivity() {

    //        make channel id & channel name
    val CHANNEL_ID =  "channel id"
    val CHANNEL_NAME = "channel name"
    val NOTIFICATION_ID = 0

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        createNotificationChannel()

        val intent = Intent(this, NotificationActivity::class.java)
        val pendingIntent = TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        }

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("This is Title Notification")
            .setContentText("This is Content Notification")
            .setSmallIcon(R.drawable.ic_home)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .build()

        val notificationManager = NotificationManagerCompat.from(this)
        btn_show_nofification.setOnClickListener {
            notificationManager.notify(NOTIFICATION_ID, notification)
        }
    }

    fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME,
            NotificationManager.IMPORTANCE_HIGH).apply {
                lightColor = R.color.white
                enableLights(true)
            }

            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(channel)

        }
    }
}