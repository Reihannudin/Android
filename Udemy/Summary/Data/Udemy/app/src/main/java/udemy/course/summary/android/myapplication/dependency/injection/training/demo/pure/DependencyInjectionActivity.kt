package udemy.course.summary.android.myapplication.dependency.injection.training.demo.pure

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import udemy.course.summary.android.myapplication.R
import udemy.course.summary.android.myapplication.databinding.ActivityDependencyInjectionBinding
import udemy.course.summary.android.myapplication.dependency.injection.training.demo.pure.data.dependencies.Battery
import udemy.course.summary.android.myapplication.dependency.injection.training.demo.pure.data.dependencies.MemoryCard
import udemy.course.summary.android.myapplication.dependency.injection.training.demo.pure.data.dependencies.ServiceProvider
import udemy.course.summary.android.myapplication.dependency.injection.training.demo.pure.data.dependencies.SimCard
import udemy.course.summary.android.myapplication.dependency.injection.training.demo.pure.data.dependent.Smartphone

class DependencyInjectionActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDependencyInjectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dependency_injection)

        val smartPhone = Smartphone(Battery(),SimCard(ServiceProvider()),MemoryCard())
            .makeACallWithRecording()
    }

}