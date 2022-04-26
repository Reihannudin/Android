package recyclerview.myapplication.practice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import recyclerview.myapplication.R
import recyclerview.myapplication.practice.adaptor.PracticeAdaptor
import recyclerview.myapplication.practice.model.PracticeModel

class PracticeActivity: AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var foodList: ArrayList<PracticeModel>
    private lateinit var practiceAdaptor: PracticeAdaptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice)

        init()
    }

    private fun init(){
        recyclerView = findViewById(R.id.recyclerView_practice)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        foodList = ArrayList()
        addDataToView()

        practiceAdaptor = PracticeAdaptor(foodList)
        recyclerView.adapter = practiceAdaptor
    }

    private fun addDataToView(){
        foodList.add(PracticeModel(R.drawable.big_mac_img, "Big mac", true ))
        foodList.add(PracticeModel(R.drawable.fillet_o_fish_img, "Fillet o Fish", true))
        foodList.add(PracticeModel(R.drawable.chicken_nugget_img, "Chicken Nugget", false))
        foodList.add(PracticeModel(R.drawable.french_fries_img, "French fires", true))
        foodList.add(PracticeModel(R.drawable.mcfurry_oreo_img, "McFurry Oreo", false))
        foodList.add(PracticeModel(R.drawable.mc_chicken_img, "McChicken", true))
        foodList.add(PracticeModel(R.drawable.burrito_img, "Burrito", false))
        foodList.add(PracticeModel(R.drawable.vanila_cone_img, "Ice Vanila", true))
        foodList.add(PracticeModel(R.drawable.quarter_chesse_img, "Quarter Cheseburger", true))

    }
}