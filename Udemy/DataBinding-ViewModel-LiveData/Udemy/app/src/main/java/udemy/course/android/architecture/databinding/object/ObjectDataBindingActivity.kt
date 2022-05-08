 package udemy.course.android.architecture.databinding.`object`

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import udemy.course.android.architecture.R
import udemy.course.android.architecture.databinding.ActivityObjectDataBindingBinding

 class ObjectDataBindingActivity: AppCompatActivity() {
    private lateinit var  binding : ActivityObjectDataBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_object_data_binding)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_object_data_binding)
//        with reference
        binding.user = getUser()

//        without reference
//        val user : User= getUser()
//        binding.tvUserName.text = user.name
//        binding.tvUserAge.text = user.age.toString()
//        binding.tvUserEmail.text = user.email
    }

     private fun getUser(): User{
         return User(1,"Reihan", 16, "reedbulls91@gmail.com")
     }
}