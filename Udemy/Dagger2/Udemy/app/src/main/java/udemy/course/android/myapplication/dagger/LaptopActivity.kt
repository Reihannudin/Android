package udemy.course.android.myapplication.dagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import udemy.course.android.myapplication.R
import udemy.course.android.myapplication.dagger.dependency.*
import udemy.course.android.myapplication.dagger.dependency.component.DaggerLaptopComponent
import udemy.course.android.myapplication.dagger.dependency.module.BrandModule
import udemy.course.android.myapplication.dagger.subclass.LaptopApplication
import javax.inject.Inject

class LaptopActivity : AppCompatActivity() {

    @Inject
    lateinit var laptop: Laptop

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_laptop)

        (application as LaptopApplication).laptopComponent
            .injectLaptop(this)
            laptop.getMyLaptop()

    }
}