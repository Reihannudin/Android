package udemy.course.summary.android.myapplication.dependency.injection.training.demo.dagger.data.dependencies.interfaces

import dagger.Binds
import dagger.Module

@Module
abstract class NameRamModule {

    @Binds
    abstract fun bindNameRam(nameRam: NameRam): Ram
}