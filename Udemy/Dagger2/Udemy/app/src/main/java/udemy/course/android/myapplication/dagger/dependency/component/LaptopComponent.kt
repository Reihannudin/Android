package udemy.course.android.myapplication.dagger.dependency.component

import dagger.Component
import udemy.course.android.myapplication.dagger.LaptopActivity
import udemy.course.android.myapplication.dagger.dependency.module.BrandModule
import udemy.course.android.myapplication.dagger.dependency.withinterface.NickelCadmiumBatteryModule
import javax.inject.Singleton

@Singleton
@Component (modules = [BrandModule::class, NickelCadmiumBatteryModule::class])
interface LaptopComponent {

    fun injectLaptop(laptopActivity: LaptopActivity)
}