package udemy.course.android.myapplication.dagger.dependency.withinterface

import dagger.Binds
import dagger.Module

@Module
abstract class NickelCadmiumBatteryModule {

    @Binds
    abstract fun bindsBattery(nickelCadmiumBattery: NickelCadmiumBattery): Battery
}