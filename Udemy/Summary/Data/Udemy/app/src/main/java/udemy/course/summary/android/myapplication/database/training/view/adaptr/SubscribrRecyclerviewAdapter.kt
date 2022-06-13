package udemy.course.summary.android.myapplication.database.training.view.adaptr

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import udemy.course.summary.android.myapplication.R
import udemy.course.summary.android.myapplication.database.challenge.data.model.Tweet
import udemy.course.summary.android.myapplication.database.training.data.model.Subscriber
import udemy.course.summary.android.myapplication.databinding.ItemSubscriberBinding

class SubscriberRecyclerviewAdapter(private val subscriberList: List<Subscriber>,
                                    private val clickListener: (Subscriber)-> Unit)
    : RecyclerView.Adapter<SubscriberRecyclerviewAdapter.SubscriberViewHolder>() {

    inner class SubscriberViewHolder(private val binding : ItemSubscriberBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(subscriber : Subscriber,clickListener : (Subscriber)-> Unit){
            binding.tvItemName.text = subscriber.name
            binding.tvItemEmail.text = subscriber.email
            binding.listItemLayout.setOnClickListener { clickListener(subscriber) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubscriberViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ItemSubscriberBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_subscriber, parent, false)
        return SubscriberViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SubscriberViewHolder, position: Int) {
        holder.bind(subscriberList[position],clickListener)
    }

    override fun getItemCount(): Int {
        return subscriberList.size
    }
}