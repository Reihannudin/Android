package com.mvvm.Journey.intents.implicit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.mvvm.Journey.R

class ImplicitActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit)

        val btnChosePhoto = findViewById<Button>(R.id.btn_chosee_photo)
        btnChosePhoto.setOnClickListener{
            Intent(Intent.ACTION_GET_CONTENT).also {
                it.type = "image/*"
                startActivityForResult(it, 0)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            data?.data?.let {
                val intent = Intent(this, ImplicitActivity::class.java)
                intent.data = it
                startActivity(intent)
            }
        }

    }
}