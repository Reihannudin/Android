package udemy.course.android.myapplication.linearlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import udemy.course.android.myapplication.R
import udemy.course.android.myapplication.linearlayout.adaptor.HorizontalAdaptor
import udemy.course.android.myapplication.linearlayout.model.HorizontalModel

class HorizontalMcdActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: HorizontalAdaptor
    private lateinit var foodList: ArrayList<HorizontalModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horizontal_mcd)

        init()
    }

    private fun init(){
        recyclerView = findViewById(R.id.LinearRecyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        foodList = ArrayList()
        addDataToView()

        viewAdapter = HorizontalAdaptor(foodList)
        recyclerView.adapter = viewAdapter
    }


    private fun addDataToView() {
        foodList.add(HorizontalModel(R.drawable.big_mac_img, "Big mac", true,3.45))
        foodList.add(HorizontalModel(R.drawable.double_cheese_img, "Double Chesseburger", true,2.00))
        foodList.add(HorizontalModel(R.drawable.mc_chicken_img, "McChicken", true,1.65))
        foodList.add(HorizontalModel(R.drawable.chicken_nugget_img, "McChicken Nugget", true,1.45))
        foodList.add(HorizontalModel(R.drawable.ice_caramel_machiato_img, "Ice Caramel Machiato", false,2.45))
        foodList.add(HorizontalModel(R.drawable.vanila_cone_img, "Ice Vanila Cone", true,0.85))
        foodList.add(HorizontalModel(R.drawable.coca_cola_img, "Coca-Cola", true,0.65))
    }

}