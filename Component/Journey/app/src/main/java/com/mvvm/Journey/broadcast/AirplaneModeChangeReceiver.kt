package com.mvvm.Journey.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneModeChangeReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val isAriplaneModeOn = intent?.getBooleanExtra("state", false) ?: false
        if(isAriplaneModeOn) {
            Toast.makeText(context, "Airplane mode is on", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(context, "Airplane mode is off", Toast.LENGTH_SHORT).show()
        }
    }
}