package com.mvvm.Journey

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class AlertDialogActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_dialog)

//        dialog allert yes or no
        val addContactDialog = AlertDialog.Builder(this)
            .setTitle("Add Contact")
            .setMessage("Do you want to add marcus to your contact list?")
            .setIcon(R.drawable.ic_add_contact_blue)
            .setPositiveButton("Yes") {_,_ ->
                Toast.makeText(this, "You add marcus to your contact list", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No") {_,_ ->
                Toast.makeText(this, "you didn't add marcus to your contact list", Toast.LENGTH_SHORT).show()
            }
            .create()
        val btnAddContactDialog = findViewById<Button>(R.id.btn_add_contact)
        btnAddContactDialog.setOnClickListener {
            addContactDialog.show()
        }


//        dialog alert single choice
//        make a list of option
        val option = arrayOf("Option 1", "Option 2", "Option 3")

//        make single choice
        val singleChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose one of the options")
            .setSingleChoiceItems(option, 0) {dialogInterface , i ->
                Toast.makeText(this, "You choose ${option[i]}", Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Accept") {_,_ ->
                Toast.makeText(this, "You accept the choice", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Decline") {_,_ ->
                Toast.makeText(this, "You decline the choice", Toast.LENGTH_SHORT).show()
            }.create()
        val btnSingleChoiceDialog = findViewById<Button>(R.id.btn_single_choice)
        btnSingleChoiceDialog.setOnClickListener {
            singleChoiceDialog.show()
        }

//        make multi choice
        val multiChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose the options")
            .setMultiChoiceItems(option, booleanArrayOf(false, false, false)) {_, i, isChecked ->
               if(isChecked){
                   Toast.makeText(this, "You choose ${option[i]}", Toast.LENGTH_SHORT).show()
               } else {
                   Toast.makeText(this, "You didn't choose ${option[i]}", Toast.LENGTH_SHORT).show()
               }
            }
            .setPositiveButton("Accept") {_,_ ->
                Toast.makeText(this, "You accept the choice", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Decline") {_,_ ->
                Toast.makeText(this, "You decline the choice", Toast.LENGTH_SHORT).show()
            }.create()

        val btnMultiChoiceDialog = findViewById<Button>(R.id.btn_multi_choice)
        btnMultiChoiceDialog.setOnClickListener {
            multiChoiceDialog.show()
        }
    }
}