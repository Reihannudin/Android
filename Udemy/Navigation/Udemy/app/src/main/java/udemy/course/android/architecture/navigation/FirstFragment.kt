package udemy.course.android.architecture.navigation

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import udemy.course.android.architecture.R
import udemy.course.android.architecture.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding : FragmentFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false)

        binding.btnFrHomeSubmit.setOnClickListener {
            if (!TextUtils.isEmpty(binding.etFrHome.text.toString())) {
//                send data to the next fragment
                val bundle = bundleOf("user_input" to binding.etFrHome.text.toString())
                findNavController().navigate(R.id.action_homeFragment_to_seondFragment, bundle)
            } else {
                Toast.makeText(activity, "Please enter some text", Toast.LENGTH_SHORT).show()
            }
        }
            return binding.root
        }
    }
