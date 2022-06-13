package udemy.course.summary.android.myapplication.dependency.injection.training.demo.hilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import udemy.course.summary.android.myapplication.R
import udemy.course.summary.android.myapplication.dependency.injection.training.demo.hilt.data.DataSource
import javax.inject.Inject

class HiltDIActivity : AppCompatActivity() {

    @Inject
    lateinit var dataSource: DataSource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hilt_diactivity)

        (application as HiltApp).dataCompponent.inject(this)
        dataSource.getRemoteData()
    }
}