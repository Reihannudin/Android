package recyclerview.myapplication.practice.adaptor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import recyclerview.myapplication.R
import recyclerview.myapplication.practice.model.PracticeModel

class PracticeAdaptor(private val foodList: ArrayList<PracticeModel>)
    :RecyclerView.Adapter<PracticeAdaptor.PracticeViewHolder>(){


    inner class PracticeViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        val imageView_practice : ImageView = itemView.findViewById(R.id.iv_hamburger)
        val textView_name_practice : TextView = itemView.findViewById(R.id.tv_practice_title)
        val textView_status_practice : TextView = itemView.findViewById(R.id.tv_practice_status)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PracticeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_practice, parent,false)
        return PracticeViewHolder(view)
    }

    override fun onBindViewHolder(holder: PracticeViewHolder, position: Int) {
        val food = foodList[position]

        val status = food.product_status
        val product_statuses = if ( status == true){ "Available" }else{ "Product out of stock" }

        holder.imageView_practice.setImageResource(food.product_image)
        holder.textView_name_practice.text = food.product_name
        holder.textView_status_practice.text = product_statuses
    }

    override fun getItemCount(): Int {
        return foodList.size
    }
}