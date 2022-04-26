package recyclerview.myapplication.grid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import recyclerview.myapplication.R
import recyclerview.myapplication.grid.adaptor.GridAdaptor
import recyclerview.myapplication.grid.model.GridModel

class GridActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var foodList : ArrayList<GridModel>
    private lateinit var gridAdaptor: GridAdaptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid)

        init()

    }

    private fun init(){
        recyclerView = findViewById(R.id.recyclerViewGrid)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        foodList = ArrayList()
        addDatatoView()

        gridAdaptor = GridAdaptor( foodList)
        recyclerView.adapter = gridAdaptor
    }

    private fun addDatatoView(){
        foodList.add(GridModel(R.drawable.big_mac_img, "Big Mac"))
        foodList.add(GridModel(R.drawable.big_mac_img, "Big Mac"))
        foodList.add(GridModel(R.drawable.big_mac_img, "Big Mac"))
        foodList.add(GridModel(R.drawable.big_mac_img, "Big Mac"))
        foodList.add(GridModel(R.drawable.big_mac_img, "Big Mac"))
        foodList.add(GridModel(R.drawable.big_mac_img, "Big Mac"))
        foodList.add(GridModel(R.drawable.big_mac_img, "Big Mac"))
        foodList.add(GridModel(R.drawable.big_mac_img, "Big Mac"))
        foodList.add(GridModel(R.drawable.big_mac_img, "Big Mac"))
        foodList.add(GridModel(R.drawable.big_mac_img, "Big Mac"))
        foodList.add(GridModel(R.drawable.big_mac_img, "Big Mac"))
        foodList.add(GridModel(R.drawable.big_mac_img, "Big Mac"))
        foodList.add(GridModel(R.drawable.big_mac_img, "Big Mac"))
        foodList.add(GridModel(R.drawable.big_mac_img, "Big Mac"))
        foodList.add(GridModel(R.drawable.big_mac_img, "Big Mac"))
    }
}