package udemy.course.android.architecture.navigation.timepicker

import android.app.TimePickerDialog
import android.os.Bundle
import android.text.format.DateFormat
import android.widget.TimePicker
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import udemy.course.android.architecture.R
import udemy.course.android.architecture.databinding.ActivityTimePickerBinding
import java.text.SimpleDateFormat
import java.util.*
import kotlin.properties.Delegates

class TimePickerActivity : AppCompatActivity() {
    private lateinit var binding : ActivityTimePickerBinding
    private lateinit var time : DataTime
//    private var tHour1 by Delegates.notNull<Int>()
//    private var tMinute1 by Delegates.notNull<Int>()
//    private var tHour2 by Delegates.notNull<Int>()
//    private var tMinute2 by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_time_picker)

        binding.tvTimer1.setOnClickListener {
            val timepickerDialog = TimePickerDialog(this,
                TimePickerDialog.OnTimeSetListener { view: TimePicker, hourOfDay: Int, minute: Int ->
                    time.t1Hour = hourOfDay
                    time.t1Minute = minute
                    val calendar = Calendar.getInstance()
                    calendar.set(0, 0, 0, hourOfDay, minute)
                    binding.tvTimer1.setText(DateFormat.format("hh:mm a", calendar))
                }, 12, 0, false)
            timepickerDialog.updateTime(time.t1Hour, time.t1Minute)
            timepickerDialog.show()
        }

        
        binding.tvTimer2.setOnClickListener{
            val timePickerDialog = TimePickerDialog(this,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                TimePickerDialog.OnTimeSetListener { view: TimePicker, hourOfDay: Int, minute: Int ->
                    time.t2Hour = hourOfDay
                    time.t2Minute = minute

                    val timmer = "$hourOfDay:$minute"
                    val f24Hours = SimpleDateFormat("HH:mm")
                    try {
                        val date = f24Hours.parse(timmer)
                        val f12Hours = SimpleDateFormat("hh:mm a")
                        binding.tvTimer2.setText(f12Hours.format(date))
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }, 12, 0, false)
            timePickerDialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)
            timePickerDialog.updateTime(time.t2Hour, time.t2Minute)
            timePickerDialog.show()
        }
    }
}
