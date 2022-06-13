package udemy.course.summary.android.myapplication.dependency.injection.training.demo.dagger.data.component

import dagger.Component
import udemy.course.summary.android.myapplication.dependency.injection.training.demo.dagger.DaggerDIActivity
import udemy.course.summary.android.myapplication.dependency.injection.training.demo.dagger.data.dependencies.interfaces.NameRamModule
import udemy.course.summary.android.myapplication.dependency.injection.training.demo.dagger.data.dependencies.thirtparty.module.HardiskModule
import udemy.course.summary.android.myapplication.dependency.injection.training.demo.dagger.data.dependent.Laptop
import javax.inject.Singleton

@Singleton
@Component(modules = [HardiskModule::class, NameRamModule::class])
interface LaptopComponent {

    fun inject(daggerDIActivity: DaggerDIActivity)
//    fun getLaptop(): Laptop
}