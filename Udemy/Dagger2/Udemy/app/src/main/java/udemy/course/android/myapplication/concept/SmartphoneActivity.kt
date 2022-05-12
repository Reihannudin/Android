package udemy.course.android.myapplication.concept

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import udemy.course.android.myapplication.R
import udemy.course.android.myapplication.concept.dependency.*

class SmartphoneActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_smartphone)

//        Constructor Injection
        val smartphone = SmartPhone(
            Battery(),
            MemoryCard(),
            SIMCard(ServiceProvider()),
        ).makeACall()

    }
}