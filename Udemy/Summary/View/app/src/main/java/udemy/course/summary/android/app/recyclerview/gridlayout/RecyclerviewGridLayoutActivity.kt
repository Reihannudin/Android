package udemy.course.summary.android.app.recyclerview.gridlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import udemy.course.summary.android.app.R
import udemy.course.summary.android.app.databinding.ActivityRecyclerviewGridLayoutBinding
import udemy.course.summary.android.app.recyclerview.gridlayout.adapter.RecyclerviewGridLayoutAdapter
import udemy.course.summary.android.app.recyclerview.gridlayout.data.RecyclerviewGridLayoutModel
import udemy.course.summary.android.app.recyclerview.linearlayout.data.RecyclerviewLinearLayoutModel


class RecyclerviewGridLayoutActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRecyclerviewGridLayoutBinding
    private lateinit var adapter : RecyclerviewGridLayoutAdapter
    private lateinit var foodList : ArrayList<RecyclerviewGridLayoutModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recyclerview_grid_layout)
        initRecyclerView()
    }

    private fun initRecyclerView(){
//        Set Recyclerview
        binding.recyclerViewGridLayout.setBackgroundColor(resources.getColor(R.color.background_mcd))
        binding.recyclerViewGridLayout.setHasFixedSize(true)
        binding.recyclerViewGridLayout.layoutManager = GridLayoutManager(this, 2)
//        set foodlist
        foodList =ArrayList()
        addDataToView()
//        set Adapter
        adapter = RecyclerviewGridLayoutAdapter(foodList)
        binding.recyclerViewGridLayout.adapter = adapter
    }

    private fun addDataToView(){
        foodList.add(RecyclerviewGridLayoutModel(R.drawable.big_mac_img,"Big Mac",4.35,30))
        foodList.add(RecyclerviewGridLayoutModel(R.drawable.double_cheese_img,"Double Chesseburger", 2.60, 50))
        foodList.add(RecyclerviewGridLayoutModel(R.drawable.hamburger_img,"Hamburger",1.75,100))
        foodList.add(RecyclerviewGridLayoutModel(R.drawable.mc_chicken_img,"McChicken",1.75,0))
        foodList.add(RecyclerviewGridLayoutModel(R.drawable.burrito_img,"Burrito",1.80,0))
        foodList.add(RecyclerviewGridLayoutModel(R.drawable.french_fries_img,"French Fries",1.50,80))
        foodList.add(RecyclerviewGridLayoutModel(R.drawable.chicken_nugget_img,"McNugget",1.60,40))
        foodList.add(RecyclerviewGridLayoutModel(R.drawable.mcfurry_oreo_img,"Oreo McFurry",2.00,10))
        foodList.add(RecyclerviewGridLayoutModel(R.drawable.vanila_cone_img,"Vanila Cone",0.80,70))
        foodList.add(RecyclerviewGridLayoutModel(R.drawable.coca_cola_img,"Coca-Cola",0.50,1200))
    }
}