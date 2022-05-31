package udemy.course.summary.android.app.recyclerview.linearlayout.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import udemy.course.summary.android.app.R
import udemy.course.summary.android.app.databinding.ItemActivityRecyclerviewLinearLayoutBinding
import udemy.course.summary.android.app.recyclerview.linearlayout.data.RecyclerviewLinearLayoutModel

class RecyclerviewLinearLayoutAdapter(private val foodList: ArrayList<RecyclerviewLinearLayoutModel>) :
    RecyclerView.Adapter<RecyclerviewLinearLayoutAdapter.myLinearLayoutViewHolder>() {

    inner class myLinearLayoutViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(food: RecyclerviewLinearLayoutModel){

            val linearLayoutImageView : ImageView = itemView.findViewById(R.id.iv_linear_layout_mcd_image)
            linearLayoutImageView.setImageResource(food.imageProduct)

            val linearLayoutName : TextView = itemView.findViewById(R.id.tv_linear_layout_title)
            linearLayoutName.text = food.nameProduct

            val linearLayoutPrice : TextView = itemView.findViewById(R.id.tv_linear_layout_price)
            linearLayoutPrice.text = "$ ${food.priceProduct}"

            val stockStatus = food.stockProduct
            val linearLayoutStatus : TextView = itemView.findViewById(R.id.tv_linear_layout_stock_status)
            if (stockStatus > 0) {
                linearLayoutStatus.text =  "Stock ${food.stockProduct}"
            } else {
                linearLayoutStatus.text =  "Out of Stock"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myLinearLayoutViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_activity_recyclerview_linear_layout, parent, false)
        return myLinearLayoutViewHolder(view)
    }

    override fun onBindViewHolder(holder: myLinearLayoutViewHolder, position: Int) {
        val food = foodList[position]
        holder.bind(food)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

}

