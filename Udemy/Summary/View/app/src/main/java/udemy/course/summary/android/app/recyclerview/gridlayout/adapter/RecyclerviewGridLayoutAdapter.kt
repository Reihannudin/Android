package udemy.course.summary.android.app.recyclerview.gridlayout.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import udemy.course.summary.android.app.R
import udemy.course.summary.android.app.recyclerview.gridlayout.data.RecyclerviewGridLayoutModel

class RecyclerviewGridLayoutAdapter(private val foodList:ArrayList<RecyclerviewGridLayoutModel>) :
    RecyclerView.Adapter<RecyclerviewGridLayoutAdapter.GridViewHolder>() {

    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(food:RecyclerviewGridLayoutModel){

            val gridLayoutImageView : ImageView = itemView.findViewById(R.id.iv_product_grid)
            gridLayoutImageView.setImageResource(food.productImage)

            val gridLayoutName : TextView = itemView.findViewById(R.id.tv_name_item_menu)
            gridLayoutName.text = food.productName

            val gridLayoutPrice : TextView = itemView.findViewById(R.id.tv_price_item_menu)
            gridLayoutPrice.text = food.productPrice.toString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_activity_recyclerview_grid_layout, parent, false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        val food = foodList[position]
        holder.bind(food)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }
}