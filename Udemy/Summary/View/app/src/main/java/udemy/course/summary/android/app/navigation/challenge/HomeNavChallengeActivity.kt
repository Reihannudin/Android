package udemy.course.summary.android.app.navigation.challenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import udemy.course.summary.android.app.R
import udemy.course.summary.android.app.databinding.ActivityHomeNavChallengeBinding
import udemy.course.summary.android.app.navigation.challenge.adapter.NavChallengeAdapter
import udemy.course.summary.android.app.navigation.challenge.model.NavChallengeModel
import kotlin.math.roundToInt

class HomeNavChallengeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeNavChallengeBinding
    private lateinit var adapter : NavChallengeAdapter
    private lateinit var foodOrderList : ArrayList<NavChallengeModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home_nav_challenge)

        initRecyclerView()

    }


    private fun initRecyclerView() {
//        set recycler view
        binding.recyclerViewNavChallenge.setBackgroundColor(resources.getColor(R.color.background_mcd))
        binding.recyclerViewNavChallenge.setHasFixedSize(true)
        binding.recyclerViewNavChallenge.layoutManager = LinearLayoutManager(this)

//        set food order list
        foodOrderList = ArrayList()
        initOrderProductList()

//    set adapter
        adapter = NavChallengeAdapter(foodOrderList)
        binding.recyclerViewNavChallenge.adapter = adapter

        binding.tvTotalPriceValue.text = "$ ${foodOrderList.sumByDouble { it.productPrice * it.productQuantity}}"
    }

    private fun initOrderProductList(){
        foodOrderList.add(NavChallengeModel( R.drawable.hamburger_img, "Hamburger", 1.50,2 ))
        foodOrderList.add(NavChallengeModel( R.drawable.french_fries_img, "French fries", 1.30,2 ))
        foodOrderList.add(NavChallengeModel( R.drawable.coca_cola_img, "Coca-cola", 0.50,2 ))
    }
}