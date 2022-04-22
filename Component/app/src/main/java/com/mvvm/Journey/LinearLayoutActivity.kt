package com.mvvm.Journey

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LinearLayoutActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linear_layout)

//        add button
        val btnRegister = findViewById<Button>(R.id.btn_register)
        btnRegister.setOnClickListener{
            val firstname = findViewById<EditText>(R.id.et_firstname).text.toString()
            val lastname = findViewById<EditText>(R.id.et_lastname).text.toString()
            val birthdate = findViewById<EditText>(R.id.et_date_birthday).text.toString()
            val email = findViewById<EditText>(R.id.et_email).text.toString()
            val password = findViewById<EditText>(R.id.et_password).text.toString()
            val contact = findViewById<EditText>(R.id.et_phone_number).text.toString()
//            add log
            Log.d("ButtonTest","Firstname: $firstname, Lastname: $lastname, Birthdate: $birthdate, Email: $email, Password: $password, Contact: $contact")
        }

    }
}