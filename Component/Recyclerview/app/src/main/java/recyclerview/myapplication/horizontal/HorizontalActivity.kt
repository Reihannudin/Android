package recyclerview.myapplication.horizontal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import recyclerview.myapplication.R
import recyclerview.myapplication.grid.model.GridModel
import recyclerview.myapplication.horizontal.adaptor.HorizontalAdaptor
import recyclerview.myapplication.horizontal.model.HorizontalModel

class HorizontalActivity: AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var foodList : ArrayList<HorizontalModel>
    private lateinit var horizontalAdaptor: HorizontalAdaptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horizontal)

        init()
    }

    private fun init(){
        recyclerView = findViewById(R.id.recyclerViewHorizontal)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        foodList = ArrayList()
        addDataToView()

        horizontalAdaptor = HorizontalAdaptor(foodList)
        recyclerView.adapter = horizontalAdaptor
    }

    private fun addDataToView(){
        foodList.add(HorizontalModel(R.drawable.burrito_img,"Burrito"))
        foodList.add(HorizontalModel(R.drawable.egg_mc_muffin,"Egg McMuffin"))
        foodList.add(HorizontalModel(R.drawable.mcpie_img,"McPie"))
        foodList.add(HorizontalModel(R.drawable.ice_caramel_machiato_img,"Ice Caramel Machiato"))
    }
}