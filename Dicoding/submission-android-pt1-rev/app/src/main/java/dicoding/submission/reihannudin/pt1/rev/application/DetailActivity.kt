package dicoding.submission.reihannudin.pt1.rev.application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import dicoding.submission.reihannudin.pt1.rev.R
import dicoding.submission.reihannudin.pt1.rev.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailBinding
    private var title : String = "Detail"

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_PRICE = "extra_price"
        const val EXTRA_IMAGE = "extra_image"
        const val EXTRA_STOCK = "extra_stock"
        const val EXTRA_DESCRIPTION = "extra_description"
        const val EXTRA_CATEGORY = "extra_category"
        const val EXTRA_ALLERGEN = "extra_allergen"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setActionBarTitle(title)

        val name = intent.getStringExtra(EXTRA_NAME)
        val price = intent.getDoubleExtra(EXTRA_PRICE, 0.0)
        val image = intent.getIntExtra(EXTRA_IMAGE, 0)
        val stock = intent.getIntExtra(EXTRA_STOCK, 0)
        val description = intent.getStringExtra(EXTRA_DESCRIPTION)
        val category = intent.getStringExtra(EXTRA_CATEGORY)
        val allergen = intent.getStringExtra(EXTRA_ALLERGEN)

        binding.imageView.setImageResource(image)
        binding.tvTitle.text = name
        binding.tvPrice.text = "$.$price"
        binding.tvStock.text = "$stock"
        binding.tvDescription.text = description
        binding.tvCategory.text = category
        binding.tvAllergen.text = allergen

    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }
}