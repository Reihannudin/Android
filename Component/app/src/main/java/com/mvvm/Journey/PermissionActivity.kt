package com.mvvm.Journey

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

class PermissionActivity: AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)
//        define request button
        val btnRequestPermission = findViewById<Button>(R.id.btn_request_permission)
        btnRequestPermission.setOnClickListener{
            requestPermission()
        }
    }

//make permission Write External Storage
    private fun permissionWriteExternalStorage() =
        ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                PackageManager.PERMISSION_GRANTED
//    make permission acces Location
    private fun permissionForegroundLocation() =
        ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED
//    make permission acces Location in background
    private fun permissionBackgroundLocation() =
        ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_BACKGROUND_LOCATION) ==
                PackageManager.PERMISSION_GRANTED
// make permission acces Camera
    private fun permissionCamera() =
        ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) ==
                PackageManager.PERMISSION_GRANTED


//     make function request permission
    @RequiresApi(Build.VERSION_CODES.O)
    private fun requestPermission(){
        val permissionToRequest = mutableListOf<String>()
//    Checked permission
        if (!permissionWriteExternalStorage()) {
            permissionToRequest.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }
        if (!permissionForegroundLocation()) {
            permissionToRequest.add(Manifest.permission.ACCESS_COARSE_LOCATION)
        }
        if (!permissionBackgroundLocation()) {
            permissionToRequest.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION)
        }
        if (!permissionCamera()) {
            permissionToRequest.add(Manifest.permission.CAMERA)
        }
//    Checked if permissionToRequest is not empty
        if (permissionToRequest.isNotEmpty()) {
            ActivityCompat.requestPermissions(this, permissionToRequest.toTypedArray(), 1)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        Checked if requestCode is 0 and not empty
        if(requestCode == 0 && grantResults.isNotEmpty()){
            for(i in grantResults.indices){
                if(grantResults[i] == PackageManager.PERMISSION_GRANTED){
                    Log.d("Permission", "Permission Granted: ${permissions[i]}")
                }else{
                    Log.d("Permission", "Permission Denied: ${permissions[i]}")
                }
            }
        }
    }
}