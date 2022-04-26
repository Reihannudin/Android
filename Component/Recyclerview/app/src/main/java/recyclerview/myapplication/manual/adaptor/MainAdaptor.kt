package recyclerview.myapplication.manual.adaptor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import recyclerview.myapplication.R
import recyclerview.myapplication.manual.model.MainModel

class MainAdaptor(private val foodList : ArrayList<MainModel>)
    : RecyclerView.Adapter<MainAdaptor.MainViewHolder>() {

    var onClickItem : (MainModel) -> Unit = {}

        inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
            val imageView : ImageView = itemView.findViewById(R.id.imageView)
            val textView : TextView = itemView.findViewById(R.id.textView)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
         val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val food = foodList[position]
        holder.imageView.setImageResource(food.image)
        holder.textView.text = food.name

        holder.itemView.setOnClickListener{
            onClickItem?.invoke(food)
        }
    }

    override fun getItemCount(): Int {
        return foodList.size
    }
}