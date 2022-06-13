package udemy.course.summary.android.myapplication.dependency.injection.training.demo.dagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import udemy.course.summary.android.myapplication.R
import udemy.course.summary.android.myapplication.databinding.ActivityDaggerDiactivityBinding
import udemy.course.summary.android.myapplication.dependency.injection.training.demo.dagger.data.application.LaptopApplication
import udemy.course.summary.android.myapplication.dependency.injection.training.demo.dagger.data.component.DaggerLaptopComponent
import udemy.course.summary.android.myapplication.dependency.injection.training.demo.dagger.data.dependencies.thirtparty.module.HardiskModule
import udemy.course.summary.android.myapplication.dependency.injection.training.demo.dagger.data.dependent.Laptop
import javax.inject.Inject

class DaggerDIActivity : AppCompatActivity() {

    @Inject
    lateinit var laptop: Laptop

    private lateinit var binding : ActivityDaggerDiactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dagger_diactivity)

//        DaggerLaptopComponent.create().inject(this)
//            laptop.makeACallWithRecording()

//        DaggerLaptopComponent.builder().hardiskModule(HardiskModule(520))
//            .build().inject(this)

        (application as LaptopApplication).laptopComponent.inject(this)
            laptop.makeACallWithRecording()
    }
}