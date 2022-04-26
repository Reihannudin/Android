package recyclerview.myapplication.grid.adaptor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import recyclerview.myapplication.R
import recyclerview.myapplication.grid.model.GridModel

class GridAdaptor(private val foodList: ArrayList<GridModel>)
    : RecyclerView.Adapter<GridAdaptor.GridViewHolder>()  {

    inner class GridViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val imgaeViewGrid : ImageView = itemView.findViewById(R.id.iv_grid_img)
        val textViewGrid :  TextView = itemView.findViewById(R.id.tv_grid_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_grid, parent, false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        val food = foodList[position]
        holder.imgaeViewGrid.setImageResource(food.image)
        holder.textViewGrid.text = food.name
    }

    override fun getItemCount(): Int {
        return foodList.size
    }
}