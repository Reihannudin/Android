package udemy.course.android.myapplication.dagger.subclass

import android.app.Application
import udemy.course.android.myapplication.dagger.dependency.component.DaggerLaptopComponent
import udemy.course.android.myapplication.dagger.dependency.component.LaptopComponent
import udemy.course.android.myapplication.dagger.dependency.module.BrandModule

class LaptopApplication: Application() {
    lateinit var laptopComponent: LaptopComponent
    override fun onCreate() {
        super.onCreate()
        laptopComponent = initDaggerDependency()
    }

    private fun initDaggerDependency(): LaptopComponent {
        return DaggerLaptopComponent.builder()
            .brandModule(BrandModule("HP"))
            .build()
    }
}