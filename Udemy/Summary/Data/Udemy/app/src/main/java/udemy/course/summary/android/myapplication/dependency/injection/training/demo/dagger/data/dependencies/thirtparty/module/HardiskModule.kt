package udemy.course.summary.android.myapplication.dependency.injection.training.demo.dagger.data.dependencies.thirtparty.module

import android.util.Log
import dagger.Module
import dagger.Provides
import udemy.course.summary.android.myapplication.dependency.injection.training.demo.dagger.data.dependencies.thirtparty.Hardisk

@Module
class HardiskModule(val hardiskSize : Int) {

    @Provides
    fun provideHardisk(): Hardisk {
        Log.i("MYTAG","Hardisk Size : $hardiskSize GB")
        return Hardisk()
    }
}