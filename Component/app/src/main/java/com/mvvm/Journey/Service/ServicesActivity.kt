package com.mvvm.Journey.Service

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mvvm.Journey.R
import kotlinx.android.synthetic.main.activity_services.*

class ServicesActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services)

        btn_start_services.setOnClickListener {
            Intent(this, MyService::class.java).also {
                startService(it)
                tv_info_service.text = "Service Started"
            }
        }

        btn_stop_services.setOnClickListener {
            Intent(this, MyService::class.java).also {
                stopService(it)
                tv_info_service.text = "Service Stopped"
            }
        }

        btn_send.setOnClickListener {
            Intent(this, MyService::class.java).also {
                val dataString = et_input_service.text.toString()
                it.putExtra("EXTRA_DATA", dataString)
                startService(it)
            }
        }

    }
}