package udemy.course.android.myapplication.gridlayout.adaptor

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import udemy.course.android.myapplication.R
import udemy.course.android.myapplication.gridlayout.model.GridModel
import udemy.course.android.myapplication.linearlayout.model.HorizontalModel

class GridAdaptor (private val foodList : ArrayList<GridModel>)
    : RecyclerView.Adapter<GridAdaptor.GridViewHolder>() {

        inner class GridViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
            fun bind(food : GridModel){
                val gridImageView : ImageView = itemView.findViewById(R.id.iv_product)
                gridImageView.setImageResource(food.image)

                val gridName : TextView = itemView.findViewById(R.id.tv_name_item_menu)
                gridName.text = food.name

                val gridPrice : TextView = itemView.findViewById(R.id.tv_price_item_menu)
                gridPrice.text = food.price.toString()
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val view = View.inflate(parent.context, R.layout.item_grid_mcd, null)
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