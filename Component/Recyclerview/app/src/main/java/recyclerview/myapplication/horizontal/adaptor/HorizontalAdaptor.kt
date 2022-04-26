package recyclerview.myapplication.horizontal.adaptor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import recyclerview.myapplication.R
import recyclerview.myapplication.grid.model.GridModel
import recyclerview.myapplication.horizontal.model.HorizontalModel

class HorizontalAdaptor(private val foodList: ArrayList<HorizontalModel>)
    : RecyclerView.Adapter<HorizontalAdaptor.HorizontalViewHolde>() {

    inner class HorizontalViewHolde(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val menu_title : TextView = itemView.findViewById(R.id.tv_menu_title)
        val menu_image : ImageView = itemView.findViewById(R.id.iv_burrito)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalViewHolde {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_horizontal, parent, false)
        return HorizontalViewHolde(view)
    }

    override fun onBindViewHolder(holder: HorizontalViewHolde, position: Int) {
        val food = foodList[position]
        holder.menu_title.text = food.title_name
        holder.menu_image.setImageResource(food.image_title)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }
}