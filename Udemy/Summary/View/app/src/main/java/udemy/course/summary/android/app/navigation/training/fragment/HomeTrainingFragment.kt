package udemy.course.summary.android.app.navigation.training.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import udemy.course.summary.android.app.R
import udemy.course.summary.android.app.databinding.FragmentHomeTrainingBinding

class HomeTrainingFragment : Fragment() {

    private lateinit var binding : FragmentHomeTrainingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_training, container, false)

        binding.btnSignUp.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeTrainingFragment_to_signUpFragment)
        }

        binding.btnToCalculateCalorie.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeTrainingFragment_to_calculator_calories)
        }

        binding.btnPrivacyPolicy.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeTrainingFragment_to_privacyPoliceFragment)
        }

        return binding.root
    }

}