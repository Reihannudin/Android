package udemy.course.android.myapplication.dagger.dependency

import android.util.Log
import udemy.course.android.myapplication.dagger.dependency.withinterface.Battery
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Laptop @Inject constructor (private val brand: Brand, private val specific: Specific, private val battery: Battery) {

    val Tag = "MyTag"

    init {
        brand.getNameBrand()
        specific.getSpec()
        battery.getBattery()
        Log.i(Tag, "Laptop constructed")
    }

    fun getMyLaptop() {
        Log.i(Tag, "This is my laptop")
    }

    fun getBrand(): String {
        return brand.getNameBrand().toString()
    }

    fun getSpecific(): String {
        return specific.getSpec().toString()
    }

    fun getBattery(): String {
        return battery.getBattery().toString()
    }
}
