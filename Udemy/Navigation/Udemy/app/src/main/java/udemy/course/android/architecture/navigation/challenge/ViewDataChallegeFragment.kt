package udemy.course.android.architecture.navigation.challenge

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import udemy.course.android.architecture.R
import udemy.course.android.architecture.databinding.FragmentViewDataChallegeBinding

class ViewDataChallegeFragment : Fragment() {
    private lateinit var binding : FragmentViewDataChallegeBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_view_data_challege, container, false)

        //        get data from bundle
        val inputName = requireArguments().getString("input_name")
        binding.tvDataName.text = inputName.toString()

        val inputEmail = requireArguments().getString("input_email")
        binding.tvDataEmail.text = inputEmail.toString()

        binding.btnTryAgain.setOnClickListener {
            it.findNavController().navigate(R.id.action_viewDataChallegeFragment_to_homeChallengeFragment)
        }

        binding.btnTermsAndConditions.setOnClickListener {
            it.findNavController().navigate(R.id.action_viewDataChallegeFragment_to_termsChallengeFragment)
        }
        return binding.root
    }
}