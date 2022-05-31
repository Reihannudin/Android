package udemy.course.summary.android.app.recyclerview.linearlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import udemy.course.summary.android.app.R
import udemy.course.summary.android.app.databinding.ActivityRecyclerviewLinearLayoutBinding
import udemy.course.summary.android.app.recyclerview.linearlayout.adapter.RecyclerviewLinearLayoutAdapter
import udemy.course.summary.android.app.recyclerview.linearlayout.data.RecyclerviewLinearLayoutModel

class RecyclerviewLinearLayoutActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRecyclerviewLinearLayoutBinding
    private lateinit var adapter: RecyclerviewLinearLayoutAdapter
    private lateinit var foodList : ArrayList<RecyclerviewLinearLayoutModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recyclerview_linear_layout)

        recyclerViewInit()

    }

    private fun recyclerViewInit(){
//        set recyclerView
        binding.recyclerViewLinearLayout.setBackgroundColor(resources.getColor(R.color.background_mcd))
        binding.recyclerViewLinearLayout.setHasFixedSize(true)
        binding.recyclerViewLinearLayout.layoutManager = LinearLayoutManager(this)
//        set foodList
        foodList = ArrayList()
        addDataToView()
//        set adapter
        adapter = RecyclerviewLinearLayoutAdapter(foodList)
        binding.recyclerViewLinearLayout.adapter = adapter
    }

    private fun addDataToView(){
        foodList.add(RecyclerviewLinearLayoutModel(R.drawable.big_mac_img,"Big Mac",4.35,30))
        foodList.add(RecyclerviewLinearLayoutModel(R.drawable.double_cheese_img,"Double Chesseburger", 2.60, 50))
        foodList.add(RecyclerviewLinearLayoutModel(R.drawable.hamburger_img,"Hamburger",1.75,100))
        foodList.add(RecyclerviewLinearLayoutModel(R.drawable.mc_chicken_img,"McChicken",1.75,0))
        foodList.add(RecyclerviewLinearLayoutModel(R.drawable.burrito_img,"Burrito",1.80,0))
        foodList.add(RecyclerviewLinearLayoutModel(R.drawable.french_fries_img,"French Fries",1.50,80))
        foodList.add(RecyclerviewLinearLayoutModel(R.drawable.chicken_nugget_img,"McNugget",1.60,40))
        foodList.add(RecyclerviewLinearLayoutModel(R.drawable.mcfurry_oreo_img,"Oreo McFurry",2.00,10))
        foodList.add(RecyclerviewLinearLayoutModel(R.drawable.vanila_cone_img,"Vanila Cone",0.80,70))
        foodList.add(RecyclerviewLinearLayoutModel(R.drawable.coca_cola_img,"Coca-Cola",0.50,1200))
    }

}