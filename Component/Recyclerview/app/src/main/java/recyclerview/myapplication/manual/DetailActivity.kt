package recyclerview.myapplication.manual

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import recyclerview.myapplication.R
import recyclerview.myapplication.manual.model.MainModel

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val food = intent.getParcelableExtra<MainModel>("food")
        if (food != null){
            val textViewTitle : TextView = findViewById(R.id.tv_detail_title)
            val imageViewDetail : ImageView = findViewById(R.id.iv_detail_image)

            textViewTitle.text = food.name
            imageViewDetail.setImageResource(food.image)
        }
    }
}