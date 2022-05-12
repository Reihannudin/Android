package udemy.course.android.myapplication.dagger.dependency

import android.util.Log

class Brand  {

    val Tag = "MyTag"

    init {
        Log.i(Tag, "Brand constructed")
    }

    fun getNameBrand() {
        Log.i(Tag, "HP EliteBook 420G")
    }

}