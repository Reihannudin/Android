package udemy.course.summary.android.myapplication.database.challenge.view.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import udemy.course.summary.android.myapplication.R
import udemy.course.summary.android.myapplication.database.challenge.data.repository.TweetRepository
import udemy.course.summary.android.myapplication.database.challenge.data.room.TweetDatabase
import udemy.course.summary.android.myapplication.database.challenge.view.adapter.TweetRecyclerviewAdapter
import udemy.course.summary.android.myapplication.database.challenge.view.viewmodel.TweetViewModel
import udemy.course.summary.android.myapplication.database.challenge.view.viewmodel.factory.TweetViewModelFactory
import udemy.course.summary.android.myapplication.database.training.view.adaptr.SubscriberRecyclerviewAdapter
import udemy.course.summary.android.myapplication.databinding.FragmentHomeBinding
import udemy.course.summary.android.myapplication.databinding.ItemTweetBinding

class HomeFragment : Fragment() {

    private var clicked = false

    private lateinit var binding : FragmentHomeBinding
    private lateinit var itemBinding : ItemTweetBinding
    private lateinit var viewModel : TweetViewModel

    private val rotateOpen : Animation by lazy {
        AnimationUtils.loadAnimation(context, R.anim.rotate_open_anim)
    }
    private val rotateClose : Animation by lazy {
        AnimationUtils.loadAnimation(context, R.anim.rotate_close_anim)
    }
    private val fromButton : Animation by lazy {
        AnimationUtils.loadAnimation(context, R.anim.from_button_anim)
    }
    private val toButton : Animation by lazy {
        AnimationUtils.loadAnimation(context, R.anim.to_button_anim)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        itemBinding = DataBindingUtil.inflate(inflater, R.layout.item_tweet, container, false)

        val dao = TweetDatabase.getInstance(this.requireContext()).tweetDao()
        val repository = TweetRepository(dao)
        val factory = TweetViewModelFactory(repository)

        viewModel = ViewModelProvider(this, factory).get(TweetViewModel::class.java)
        binding.lifecycleOwner = this


        binding.faBtnAdd.setOnClickListener {
            onAddButtonClicked()
        }

        itemBinding.ivSelectedOption.setOnClickListener {

        }

        binding.faBtnTweet.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_addFragment)
            Toast.makeText(context, "Tweet button clicked", Toast.LENGTH_SHORT).show()
        }


        binding.faBtnImage.setOnClickListener {
            Toast.makeText(context, "Image button clicked", Toast.LENGTH_SHORT).show()
        }

        initRecyclerview()

        return binding.root
    }

    private fun initRecyclerview(){
        binding.tweetRecyclerView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context)
        displayTweetList()
    }

    private fun displayTweetList(){
        viewModel.tweet.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            Log.i("MyTag", "SubscriberActivity: $it")
            binding.tweetRecyclerView.adapter = TweetRecyclerviewAdapter(it)
        })
    }

    private fun onAddButtonClicked(){
        setVisibility(clicked)
        setAnimation(clicked)
        setClickable(clicked)
        clicked = !clicked
    }

    private fun setVisibility(clicked : Boolean){
        if(!clicked){
            binding.faBtnTweet.visibility = View.VISIBLE
            binding.faBtnImage.visibility = View.VISIBLE
        }else{
            binding.faBtnTweet.visibility = View.INVISIBLE
            binding.faBtnImage.visibility = View.INVISIBLE
        }
    }

    private fun setAnimation(clicked: Boolean){
        if(!clicked){
            binding.faBtnAdd.startAnimation(rotateOpen)
            binding.faBtnTweet.startAnimation(fromButton)
            binding.faBtnImage.startAnimation(fromButton)
        }else{
            binding.faBtnAdd.startAnimation(rotateClose)
            binding.faBtnTweet.startAnimation(toButton)
            binding.faBtnImage.startAnimation(toButton)
        }
    }

    private fun setClickable(clicked: Boolean){
        if(!clicked){
            binding.faBtnTweet.isClickable = true
            binding.faBtnImage.isClickable = true
        }else{
            binding.faBtnTweet.isClickable = false
            binding.faBtnImage.isClickable = false
        }
    }
}