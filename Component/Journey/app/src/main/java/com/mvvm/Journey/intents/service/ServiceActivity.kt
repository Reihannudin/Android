package com.mvvm.Journey.intents.service

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mvvm.Journey.R
import kotlinx.android.synthetic.main.activity_service.*

class ServiceActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        btn_start_service.setOnClickListener {
            Intent(this, MyIntentService::class.java).also {
                startService(it)
                tv_status_service.text = "Service Started"
            }
        }

        btn_stop_service.setOnClickListener {
                MyIntentService.stopService()
                tv_status_service.text = "Service Stopped"
            }
        }
    }
