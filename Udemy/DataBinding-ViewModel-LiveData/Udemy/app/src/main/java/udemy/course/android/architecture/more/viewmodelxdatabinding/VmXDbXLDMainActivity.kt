package udemy.course.android.architecture.more.viewmodelxdatabinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import udemy.course.android.architecture.R
import udemy.course.android.architecture.databinding.ActivityVmXDbMainBinding

class VmXDbXLDMainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityVmXDbMainBinding
    private lateinit var XLdViewModel: VmXDbXLdViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_vm_x_db_main)
        XLdViewModel = ViewModelProvider(this).get(VmXDbXLdViewModel::class.java)

        binding.lifecycleOwner = this
        binding.myViewModel = XLdViewModel
    }
}