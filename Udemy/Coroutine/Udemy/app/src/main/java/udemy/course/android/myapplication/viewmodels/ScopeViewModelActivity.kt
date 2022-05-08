package udemy.course.android.myapplication.viewmodels

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import udemy.course.android.myapplication.R
import udemy.course.android.myapplication.databinding.ActivityScopeViewModelBinding
import udemy.course.android.myapplication.viewmodels.viewmodel.UserViewModel

class ScopeViewModelActivity : AppCompatActivity() {
    private lateinit var binidng : ActivityScopeViewModelBinding
    private lateinit var viewModel : UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binidng = DataBindingUtil.setContentView(this, R.layout.activity_scope_view_model)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
//        viewModel.getUserData()
        viewModel.users.observe(this, Observer{ myUsers ->
            myUsers.forEach{
                Log.i("myTag","Name user ${it.name}")
            }
        })
    }
}