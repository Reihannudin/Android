package dicoding.submission.reihannudin.pt1.rev.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dicoding.submission.reihannudin.pt1.rev.databinding.ItemHomeBinding
import dicoding.submission.reihannudin.pt1.rev.model.Food

class HomeRecyclerViewAdapter (private val foodList: ArrayList<Food>): RecyclerView.Adapter<HomeRecyclerViewAdapter.HomeRecyclerViewHolder>() {

    private lateinit var onItemClickCallback:  OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: Any) {
        this.onItemClickCallback = onItemClickCallback as OnItemClickCallback
    }

    inner class HomeRecyclerViewHolder(private var binding : ItemHomeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(productFood: Food){
            binding.tvLinearLayoutTitle.text = productFood.nameProduct
            binding.tvLinearLayoutPrice.text = "$." + productFood.priceProduct.toString()

//            binding.tvCategory.text = productFood.categoryProduct
//            binding.tvDescription.text = productFood.descriptionProduct
//            binding.tvAllergenInformation.text = productFood.allergenInformation

            Glide.with(itemView.context)
                .load(productFood.imageProduct)
                .into(binding.ivLinearLayoutMcdImage)

            if (productFood.stockProduct >= 1){
                binding.tvLinearLayoutStockStatus.text = "Stock : ${productFood.stockProduct}"
            } else {
                binding.tvLinearLayoutStockStatus.text = "Out of Stock"
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRecyclerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemHomeBinding.inflate(layoutInflater, parent, false)
        return HomeRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeRecyclerViewHolder, position: Int) {
        holder.bind(foodList[position])
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(foodList[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Food)
    }
}