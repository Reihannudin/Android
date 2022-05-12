package udemy.course.android.myapplication.dagger.dependency.withinterface

import android.util.Log
import javax.inject.Inject

class NickelCadmiumBattery @Inject constructor() : Battery {

    private val Tag = "MyTag"
    override fun getBattery() {
        Log.i(Tag, "Battery Type : Nickel Cadmium Battery")
    }
}