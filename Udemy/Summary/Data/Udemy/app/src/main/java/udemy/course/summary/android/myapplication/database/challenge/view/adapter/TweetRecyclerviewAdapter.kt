package udemy.course.summary.android.myapplication.database.challenge.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import udemy.course.summary.android.myapplication.R
import udemy.course.summary.android.myapplication.database.challenge.data.model.Tweet
import udemy.course.summary.android.myapplication.databinding.ItemTweetBinding

class TweetRecyclerviewAdapter(private var tweetList: List<Tweet>)
    : RecyclerView.Adapter<TweetRecyclerviewAdapter.TweetViewHolder>() {


    inner class TweetViewHolder(private val binding : ItemTweetBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tweet : Tweet){
            binding.profileImage.setImageResource(tweet.image)
            binding.tvItemUsername.text = tweet.userName
            binding.tvItemTweet.text = tweet.tweet

//            binding.ivSelectedOption.setOnClickListener {
//                popUpMenuTweet(it)
//            }
        }

//
//        private fun popUpMenuTweet(view: View){
//            val popupMenu = PopupMenu(context, view)
//            popupMenu.inflate(R.menu.options_menu_selected)
//            popupMenu.setOnMenuItemClickListener {
//                when (it.itemId) {
//                    R.id.deleteTweet -> {
//                        Toast.makeText(context, "Delete Tweet", Toast.LENGTH_SHORT).show()
//                        true
//                    }
//                    R.id.editTweet -> {
//                        Toast.makeText(context, "Edit Tweet", Toast.LENGTH_SHORT).show()
//                        true
//                    }
//                    else -> false
//                }
//            }
//            popupMenu.show()
//            val popup = PopupMenu::class.java.getDeclaredField("menuPopup")
//            popup.isAccessible = true
//
//            val menu = popup.get(popupMenu)
//            menu.javaClass.getDeclaredMethod("setForceShowIcon", Boolean::class.java)
//                .invoke(menu, true)
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TweetViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ItemTweetBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_tweet, parent, false)
        return TweetViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TweetViewHolder, position: Int) {
        holder.bind(tweetList[position])
    }

    override fun getItemCount(): Int {
        return tweetList.size
    }

}
