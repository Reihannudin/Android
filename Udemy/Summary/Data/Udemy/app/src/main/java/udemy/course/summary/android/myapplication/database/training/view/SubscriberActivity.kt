package udemy.course.summary.android.myapplication.database.training.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import udemy.course.summary.android.myapplication.R
import udemy.course.summary.android.myapplication.database.training.data.model.Subscriber
import udemy.course.summary.android.myapplication.database.training.data.repository.SubscriberRepository
import udemy.course.summary.android.myapplication.database.training.data.room.SubscriberDatabase
import udemy.course.summary.android.myapplication.database.training.view.adaptr.SubscriberRecyclerviewAdapter
import udemy.course.summary.android.myapplication.database.training.view.viewmodel.SubscriberViewmodel
import udemy.course.summary.android.myapplication.database.training.view.viewmodel.factory.SubscriberViewModelFactory
import udemy.course.summary.android.myapplication.databinding.ActivitySubscriberBinding

class SubscriberActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySubscriberBinding
    private lateinit var viewModel : SubscriberViewmodel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_subscriber)

        val dao = SubscriberDatabase.getInstance(this).subscriberDao()
        val repository = SubscriberRepository(dao)
        val factory = SubscriberViewModelFactory(repository)

        viewModel = ViewModelProvider(this, factory).get(SubscriberViewmodel::class.java)
        binding.myViewModel = viewModel
        binding.lifecycleOwner = this
        initRecyclerview()

        viewModel.message.observe(this, Observer{
            it.getContentIfNotHandled()?.let{
                Toast.makeText(this,it,Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun initRecyclerview(){
        binding.subscriberRecyclerView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        displaySubscriberList()
    }

    private fun displaySubscriberList(){
        viewModel.subscriber.observe(this, androidx.lifecycle.Observer {
            Log.i("MyTag", "SubscriberActivity: $it")
            binding.subscriberRecyclerView.adapter = SubscriberRecyclerviewAdapter(it) { selectedItem: Subscriber ->
                listItemClicked(
                    selectedItem
                )
            }
        })
    }

    private fun listItemClicked(subscriber: Subscriber){
        Toast.makeText(this, "List Item Clicked ${subscriber.name}", Toast.LENGTH_SHORT).show()
        viewModel.initUpdateOrDelete(subscriber)
    }
}