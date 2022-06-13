package udemy.course.summary.android.myapplication.dependency.injection.training.demo.dagger.data.application

import android.app.Application
import udemy.course.summary.android.myapplication.dependency.injection.training.demo.dagger.data.component.DaggerLaptopComponent
import udemy.course.summary.android.myapplication.dependency.injection.training.demo.dagger.data.component.LaptopComponent
import udemy.course.summary.android.myapplication.dependency.injection.training.demo.dagger.data.dependencies.thirtparty.module.HardiskModule

class LaptopApplication : Application() {

    lateinit var laptopComponent: LaptopComponent
    override fun onCreate() {
        super.onCreate()
        laptopComponent = initDagger()
    }

    private fun initDagger(): LaptopComponent {
        return DaggerLaptopComponent.builder().hardiskModule(HardiskModule(520))
            .build()
    }
}