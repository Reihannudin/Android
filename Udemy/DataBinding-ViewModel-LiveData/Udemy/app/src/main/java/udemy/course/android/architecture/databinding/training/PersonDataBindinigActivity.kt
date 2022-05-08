package udemy.course.android.architecture.databinding.training

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import udemy.course.android.architecture.R
import udemy.course.android.architecture.databinding.ActivityPersonDataBindinigBinding

class PersonDataBindinigActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPersonDataBindinigBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_person_data_bindinig)
        binding.person = getPerson()
    }

    private fun getPerson() : Person {
        return Person(1, "Reihan", 16, "Male", "Indonesia")
    }
}