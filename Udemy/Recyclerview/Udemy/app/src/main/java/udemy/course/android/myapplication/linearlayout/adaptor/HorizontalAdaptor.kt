package udemy.course.android.myapplication.linearlayout.adaptor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import udemy.course.android.myapplication.R
import udemy.course.android.myapplication.linearlayout.model.HorizontalModel

class HorizontalAdaptor(private val foodList : ArrayList<HorizontalModel>)
    : RecyclerView.Adapter<HorizontalAdaptor.HorizontalViewHolder>() {

    inner class HorizontalViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(food: HorizontalModel) {
            val horizontalImageView : ImageView = itemView.findViewById(R.id.iv_horizontal_mcd_image)
            horizontalImageView.setImageResource(food.image)

            val horizontalName : TextView = itemView.findViewById(R.id.tv_horizontal_title)
            horizontalName.text = food.name

            val horizontalPrice : TextView = itemView.findViewById(R.id.tv_horizontal_price)
            horizontalPrice.text = food.price.toString()

            val status = food.status
            val productStatus = if (status == true) {"Available"} else {"Out of stock"}
            val horizontalStatus : TextView = itemView.findViewById(R.id.tv_horizontal_status)
            horizontalStatus.text = productStatus
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_horizontal_mcd, parent, false)
        return HorizontalViewHolder(view)
    }

    override fun onBindViewHolder(holder: HorizontalViewHolder, position: Int) {
        val food =foodList[position]
        holder.bind(food)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }
}