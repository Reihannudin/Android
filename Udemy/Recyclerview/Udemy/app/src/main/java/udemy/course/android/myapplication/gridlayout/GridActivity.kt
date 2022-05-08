package udemy.course.android.myapplication.gridlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import udemy.course.android.myapplication.R
import udemy.course.android.myapplication.gridlayout.adaptor.GridAdaptor
import udemy.course.android.myapplication.gridlayout.model.GridModel
import udemy.course.android.myapplication.linearlayout.adaptor.HorizontalAdaptor
import udemy.course.android.myapplication.linearlayout.model.HorizontalModel

class GridActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: GridAdaptor
    private lateinit var foodList: ArrayList<GridModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid)

        init()

    }

    private fun init(){
        recyclerView = findViewById(R.id.gridRecyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        foodList = ArrayList()
        addDataToView()

        viewAdapter = GridAdaptor(foodList)
        recyclerView.adapter = viewAdapter
    }

    private fun addDataToView() {
        foodList.add(GridModel(R.drawable.big_mac_img, "Big Mac" , 3.45))
        foodList.add(GridModel(R.drawable.double_cheese_img, "Double CheeseBurger" , 1.85))
        foodList.add(GridModel(R.drawable.quarter_chesse_img, "Quarter CheseeBurger" , 2.45))
        foodList.add(GridModel(R.drawable.mc_chicken_img, "McChicken" , 1.65))
        foodList.add(GridModel(R.drawable.burrito_img, "Buritto" , 2.45))
        foodList.add(GridModel(R.drawable.chicken_nugget_img, "Chicken Nugget" , 1.45))
        foodList.add(GridModel(R.drawable.double_cheese_img, "Double CheeseBurger" , 1.85))
        foodList.add(GridModel(R.drawable.quarter_chesse_img, "Quarter CheseeBurger" , 2.45))
        foodList.add(GridModel(R.drawable.mc_chicken_img, "McChicken" , 1.65))
        foodList.add(GridModel(R.drawable.burrito_img, "Buritto" , 2.45))
        foodList.add(GridModel(R.drawable.chicken_nugget_img, "Chicken Nugget" , 1.45))
    }
}