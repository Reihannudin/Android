package udemy.course.android.myapplication.withhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import udemy.course.android.myapplication.R
import javax.inject.Inject

@AndroidEntryPoint
class MainHiltActivity : AppCompatActivity() {

    @Inject
    lateinit var hiltDataSource: HiltDataSource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_hilt)

//        (application as HiltDataApp).hiltDataComponent.inject(this)
        hiltDataSource.getRemoteData()
    }
}