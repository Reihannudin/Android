package programmerzamannow.android_basic

import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
//     best practice: get view id is use late init
    private lateinit var nameEditText: EditText
    private lateinit var sayHelloButton: Button
    private lateinit var sayHelloTextView: TextView
//    make function initComponent
    private fun initComponent(){
        nameEditText = findViewById(R.id.nameEditText)
        sayHelloButton = findViewById(R.id.sayHelloButton)
        sayHelloTextView = findViewById(R.id.sayHelloTextView)
    }

//    <!--    device compability : programmatic  -->
    private fun checkFingerprint(){
        if(packageManager.hasSystemFeature(PackageManager.FEATURE_FINGERPRINT)){
            Log.i("FEATURE", "This device has fingerprint sensor")
        }else{
            Log.w("FEATURE", "This device does not have fingerprint sensor")
        }
    }

//    check platform version
    private fun checkPlatformVersion() {
    Log.i("SDK", Build.VERSION.SDK_INT.toString())
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S) {
        Log.i("SDK", "This device is not support, because SDK version is lower than 31")
    }
}

//    make debug log
    private fun debugHello(name:String){
        Log.i("DEBUG",  name)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello_world)

//        get view id like this not recommended bcs program will slow
//        val nameEditText : EditText = findViewById(R.id.nameEditText)
//        val sayHelloButton : Button = findViewById(R.id.sayHelloButton)
//        val sayHelloTextView : TextView = findViewById(R.id.helloTextView)

//         call initComponent function
        initComponent()

////        aplication context
//        applicationContext
////        activityContext
//        resources

//        add resource in main activity
        sayHelloTextView.text = resources.getText(R.string.app_name)

        // use sayHelloTextView to show hello world
        sayHelloButton.setOnClickListener {

//            call debugHello function
            val firstName = "REIHANNUDIN"
            debugHello(firstName)

//          call checkFingerprint
            checkFingerprint()

//            call checkPlatformVersion
            checkPlatformVersion()

//            make raw resource
            val rawResource = resources.openRawResource(R.raw.sample).bufferedReader().use {
                it.readText()
            }
            Log.i("rawResource", rawResource)

//             make assets manager
            val assetsManager= assets.open("sample.json").bufferedReader().use {
                it.readText()
            }
//            add log json
            Log.i("ASSETS", assetsManager)


//            add drawlabel in main activity
//            resources.getDrawable(R.drawable.bts_logo, theme)

//            add log
            Log.d("PZN", "This is debug log")
            Log.i("PZN", "This is info log")
            Log.w("PZN", "This is warning log")
            Log.e("PZN", "This is error log")

            // get name from nameEditText
            val name = nameEditText.text.toString()

            //get integer from resources and use log to show
            Log.i("ValueResources", resources.getInteger(R.integer.maxNumber).toString())
//            get array integer from resources and use log to show
            Log.i("ValueResources", resources.getIntArray(R.array.numbers).joinToString(","))
//            get boolean from resources and use log to show
            Log.i("ValueResources", resources.getBoolean(R.bool.isProductionMode).toString())
//            get color from resources and use log to show
            Log.i("ValueResources", resources.getColor(R.color.background, theme).toString())

//            make button change color if was click
            sayHelloButton.setBackgroundColor(resources.getColor(R.color.background, theme))

//            get say hello text from string resource
            sayHelloTextView.text = resources.getString(R.string.sayHelloTextView, name)

//            get string array from string resource
            val stringArray = resources.getStringArray(R.array.names)
            for (item in stringArray){ // loop string array
                Log.i("PZN", item) // use log to show string array
            }
        }

    }
}