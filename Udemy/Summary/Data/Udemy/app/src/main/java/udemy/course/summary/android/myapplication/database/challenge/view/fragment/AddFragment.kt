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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import udemy.course.summary.android.myapplication.R
import udemy.course.summary.android.myapplication.database.challenge.data.repository.TweetRepository
import udemy.course.summary.android.myapplication.database.challenge.data.room.TweetDatabase
import udemy.course.summary.android.myapplication.database.challenge.view.viewmodel.TweetViewModel
import udemy.course.summary.android.myapplication.database.challenge.view.viewmodel.factory.TweetViewModelFactory
import udemy.course.summary.android.myapplication.databinding.FragmentAddBinding

class AddFragment : Fragment() {

    private var clicked = false

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

    private lateinit var binding : FragmentAddBinding
    private lateinit var viewModel : TweetViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add, container, false)

        val dao = TweetDatabase.getInstance(this.requireContext()).tweetDao()
        val repository = TweetRepository(dao)
        val factory = TweetViewModelFactory(repository)

        viewModel = ViewModelProvider(this, factory).get(TweetViewModel::class.java)
        binding.myViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.message.observe(viewLifecycleOwner, Observer{
            Log.i("MyTag", it.toString())
        })

        binding.btnTweet.setOnClickListener {
            viewModel.btnCreateTweet()
            displayTweet()
            it.findNavController().navigate(R.id.action_addFragment_to_homeFragment)
        }


        binding.btnDiscard.setOnClickListener {
            viewModel.btnDiscard()
        }

        binding.ivBack.setOnClickListener {
            it.findNavController().navigate(R.id.action_addFragment_to_homeFragment)
            setAnimation(clicked)
            clicked = !clicked
            Toast.makeText(context, "back to home", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

    private fun displayTweet(){
        viewModel.tweet.observe(viewLifecycleOwner, Observer {
            Log.i("MyTag", "AddFragment : $it")
        })
    }

    private fun setAnimation(clicked: Boolean){
        if(!clicked){
            binding.ivBack.startAnimation(rotateClose)
        }else{
            binding.ivBack.startAnimation(rotateOpen)
        }
    }

}