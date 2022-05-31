package udemy.course.summary.android.app.navigation.challenge.fragment

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import udemy.course.summary.android.app.R
import udemy.course.summary.android.app.databinding.ActivityHomeNavChallengeBinding
import udemy.course.summary.android.app.navigation.challenge.adapter.NavChallengeAdapter
import udemy.course.summary.android.app.navigation.challenge.model.NavChallengeModel

class NavOrderFragment : Fragment() {

    private lateinit var binding : ActivityHomeNavChallengeBinding
    private lateinit var adapter : NavChallengeAdapter
    private lateinit var foodOrderList : ArrayList<NavChallengeModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.activity_home_nav_challenge, container, false)

        initRecyclerView()

        binding.btnOrder.setOnClickListener {
            it.findNavController().navigate(R.id.action_navOrderFragment_to_navInputAddressFragment2)
        }

        return binding.root
    }

    private fun initRecyclerView(){
        //        set recycler view
        binding.recyclerViewNavChallenge.setBackgroundColor(resources.getColor(R.color.background_mcd))
        binding.recyclerViewNavChallenge.setHasFixedSize(true)
        binding.recyclerViewNavChallenge.layoutManager = LinearLayoutManager(context)

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