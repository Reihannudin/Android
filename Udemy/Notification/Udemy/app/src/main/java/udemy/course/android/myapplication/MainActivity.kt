package udemy.course.android.myapplication

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_UPDATE_CURRENT
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.RemoteInput
import androidx.databinding.DataBindingUtil
import udemy.course.android.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val channelID = "udemy.course.android.myapplication.channel1"
    private lateinit var notificationManager : NotificationManager

//    reply
    private val KEY_REPLY = "key_reply"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        createNotificationChannel(channelID,"Demo Notification", "This is a my demo notification")
        binding.button.setOnClickListener {
            displayNotification()
        }
    }

    private fun displayNotification(){
        val notificationId = 45

        val intenMain = Intent(this, MainActivity::class.java)
        val pendingIntentMain = PendingIntent.getActivity(this, 0, intenMain, FLAG_UPDATE_CURRENT)

        val intentSecond = Intent(this, SecondActivity::class.java)
        val pendingIntentSecond = PendingIntent.getActivity(this, 0, intentSecond, FLAG_UPDATE_CURRENT)

//        reply action
        val remoteInput = RemoteInput.Builder(KEY_REPLY).run {
            setLabel("Reply a message")
            build()
        }
        val replyAction = NotificationCompat.Action.Builder(
            0, "Reply", pendingIntentSecond
        ).addRemoteInput(remoteInput).build()

        val intentDetail = Intent(this, DetailActivity::class.java)
        val pendingIntentDetail = PendingIntent.getActivity(this, 0, intentDetail, FLAG_UPDATE_CURRENT)
        val actionDetail = NotificationCompat.Action.Builder(0, "Detail", pendingIntentDetail).build()

        val intentSetting = Intent(this, SettingActivity::class.java)
        val pendingIntentSetting = PendingIntent.getActivity(this, 0, intentSetting, FLAG_UPDATE_CURRENT)
        val actionSetting = NotificationCompat.Action.Builder(0, "Setting", pendingIntentSetting).build()

        val notification = NotificationCompat.Builder(this , channelID)
            .setContentTitle("Demo Notification")
            .setContentText("This is a my demo notification")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
//            .setContentIntent(pendingIntentSecond)
            .addAction(actionSetting)
            .addAction(actionDetail)
            .addAction(replyAction)
            .build()
        notificationManager.notify(notificationId, notification)

    }

    private fun createNotificationChannel(id: String, name:String, channelDescription: String){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(id, name, importance).apply {
                description = channelDescription
            }
            notificationManager.createNotificationChannel(channel)
        }

    }
}