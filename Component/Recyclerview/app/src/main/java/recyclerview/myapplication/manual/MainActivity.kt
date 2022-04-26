package recyclerview.myapplication.manual

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import recyclerview.myapplication.R
import recyclerview.myapplication.manual.adaptor.MainAdaptor
import recyclerview.myapplication.manual.model.MainModel

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var foodList : ArrayList<MainModel>
    private lateinit var  foodAdaptor : MainAdaptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        foodList = ArrayList()

        foodList.add(MainModel(R.drawable.big_mac_img,"Big mac"))
        foodList.add(MainModel(R.drawable.burrito_img,"Burrito"))
        foodList.add(MainModel(R.drawable.chicken_nugget_img,"Chicken Nugget"))
        foodList.add(MainModel(R.drawable.choco_shake_img,"Choco Shake"))
        foodList.add(MainModel(R.drawable.coca_cola_img,"Coca Cola"))
        foodList.add(MainModel(R.drawable.spicy_chicken_img,"Spicy Chicken"))
        foodList.add(MainModel(R.drawable.double_cheese_img,"Double Cheese"))
        foodList.add(MainModel(R.drawable.french_fries_img,"French Fries"))
        foodList.add(MainModel(R.drawable.fillet_o_fish_img,"Filllet of Fish"))

        foodAdaptor = MainAdaptor(foodList)
        recyclerView.adapter = foodAdaptor

        foodAdaptor.onClickItem = {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("food",it)
            startActivity(intent)
        }
    }
}