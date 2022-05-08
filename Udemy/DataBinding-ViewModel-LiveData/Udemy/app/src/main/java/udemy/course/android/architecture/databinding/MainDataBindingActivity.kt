package udemy.course.android.architecture.databinding

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import udemy.course.android.architecture.R

/*How to Build Data Binding
* 1. Enabled data binding
* 2. Wrap XML with layout Tags
* 3. Define construct a data binding object
* 4. Eliminate findViewById(*/

class MainDataBindingActivity: AppCompatActivity() {

    private lateinit var binding : ActivityMainDataBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Without binding
//        setContentView(R.layout.activity_main_data_binding)

//        With binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_data_binding)

//        val button_greating : Button = findViewById(R.id.btn_submit)
        binding.btnSubmit.setOnClickListener{
            displayGreatting()
        }
    }

    private fun displayGreatting(){
//        without binding
//        val tv_greating : TextView = findViewById(R.id.tv_greating)
//        val et_greating : EditText = findViewById(R.id.et_set_your_name)

//        with binding
        binding.tvGreating.text = "Hello ${binding.etSetYourName.text}"
    }
}