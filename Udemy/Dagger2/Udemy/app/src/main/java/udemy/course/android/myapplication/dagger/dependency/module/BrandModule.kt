package udemy.course.android.myapplication.dagger.dependency.module

import android.util.Log
import dagger.Module
import dagger.Provides
import udemy.course.android.myapplication.dagger.dependency.Brand

@Module
class BrandModule(val merk : String) {

    @Provides
    fun providesBrandModule(): Brand{
        Log.i("MyTag","Merk : $merk")
        return Brand()
    }
}