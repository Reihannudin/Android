package udemy.course.android.myapplication.withouthilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import udemy.course.android.myapplication.R
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var dataSource: DataSource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as DataApp).dataComponent.inject(this)
        dataSource.getRemoteData()
    }
}