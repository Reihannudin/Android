package udemy.course.summary.android.app.navigation.challenge.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import udemy.course.summary.android.app.R
import udemy.course.summary.android.app.navigation.challenge.model.NavChallengeModel

class NavChallengeAdapter(private val foodOrderList : ArrayList<NavChallengeModel>)
    : RecyclerView.Adapter<NavChallengeAdapter.NavChallengeViewHolder>() {

    inner class NavChallengeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(foodOrder: NavChallengeModel){

            val foodOrderImage:ImageView = itemView.findViewById(R.id.iv_nav_challenge_mcd_image)
            foodOrderImage.setImageResource(foodOrder.productImage)

            val foodOrderName:TextView = itemView.findViewById(R.id.tv_nav_challenge_title)
            foodOrderName.text = foodOrder.productName

            val foodOrderPrice:TextView = itemView.findViewById(R.id.tv_nav_challenge_price)
            foodOrderPrice.text = "$" + foodOrder.productPrice.toString()

            val foodOrderQuantity:TextView = itemView.findViewById(R.id.tv_nav_challenge_quantity)
            foodOrderQuantity.text = foodOrder.productQuantity.toString()

            if (foodOrder.productQuantity > 1){
                foodOrder.productPrice = foodOrder.productPrice * foodOrder.productQuantity
                foodOrderPrice.text = foodOrder.productPrice.toString()
            } else if (foodOrder.productQuantity == 1){
                foodOrderPrice.text = foodOrder.productPrice.toString()
            }else if (foodOrder.productQuantity == 0){
                foodOrderPrice.text = "0"
            }
//
//            val foodOrderTotal:TextView = itemView.findViewById(R.id.tv_total_price_value)
//            foodOrderTotal.text = foodOrder.productPrice.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavChallengeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_activity_nav_challenge, parent, false)
        return NavChallengeViewHolder(view)
    }

    override fun onBindViewHolder(holder: NavChallengeViewHolder, position: Int) {
        val food = foodOrderList[position]
        holder.bind(food)
    }

    override fun getItemCount(): Int {
        return foodOrderList.size
    }
}