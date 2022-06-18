package dicoding.submission.reihannudin.pt1.rev.application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import dicoding.submission.reihannudin.pt1.rev.R
import dicoding.submission.reihannudin.pt1.rev.adapter.HomeRecyclerViewAdapter
import dicoding.submission.reihannudin.pt1.rev.data.FoodData
import dicoding.submission.reihannudin.pt1.rev.databinding.ActivityHomeBinding
import dicoding.submission.reihannudin.pt1.rev.model.Food

class HomeActivity : AppCompatActivity() {

    private lateinit var binding :ActivityHomeBinding
    private lateinit var adapter: HomeRecyclerViewAdapter
    private var foodList: ArrayList<Food> = arrayListOf()

    private var title : String = "Home"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        setActionBarTitle(title)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        binding.recyclerViewHome.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewHome.setHasFixedSize(true)

        foodList.addAll(FoodData.listData)
        adapter = HomeRecyclerViewAdapter(foodList)

        adapter.setOnItemClickCallback(object : HomeRecyclerViewAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Food) {
                showSelectedFood(data)
            }
        })

        binding.recyclerViewHome.adapter = adapter
    }

    private fun showSelectedFood(food: Food) {

        Intent(this, DetailActivity::class.java).also {
            it.putExtra(DetailActivity.EXTRA_NAME, food.nameProduct)
            it.putExtra(DetailActivity.EXTRA_PRICE, food.priceProduct)
            it.putExtra(DetailActivity.EXTRA_IMAGE, food.imageProduct)
            it.putExtra(DetailActivity.EXTRA_STOCK, food.stockProduct)
            it.putExtra(DetailActivity.EXTRA_DESCRIPTION, food.descriptionProduct)
            it.putExtra(DetailActivity.EXTRA_CATEGORY, food.categoryProduct)
            it.putExtra(DetailActivity.EXTRA_ALLERGEN, food.allergenInformation)
        }.also {
            startActivity(it)
        }
        Toast.makeText(this, "Kamu memilih " + food.nameProduct, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_to_about -> {
                title = "About"
                Intent(this, AboutActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }
}