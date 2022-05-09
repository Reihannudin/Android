package udemy.course.android.myapplication

import android.app.NotificationManager
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.RemoteInput
import androidx.databinding.DataBindingUtil
import udemy.course.android.myapplication.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_second)
        receiveInput()
    }

    private fun receiveInput(){
        val KEY_REPLY = "key_reply"


        val intent = this.intent
        val remoteInput = RemoteInput.getResultsFromIntent(intent)
        if(remoteInput != null){
            val inputString = remoteInput.getCharSequence( KEY_REPLY).toString()
            binding.textView.text = inputString

            val channelID = "udemy.course.android.myapplication.channel1"
            val notificationId = 45

            val repliedNotification = NotificationCompat.Builder(this, channelID)
                .setSmallIcon(R.drawable.ic_launcher_foreground).setContentText("You replied: $inputString").build()

            val afterRepliedNotification = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            afterRepliedNotification.notify(notificationId, repliedNotification)
        }
    }
}