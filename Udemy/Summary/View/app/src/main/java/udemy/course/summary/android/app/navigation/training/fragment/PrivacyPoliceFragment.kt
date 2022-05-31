package udemy.course.summary.android.app.navigation.training.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import udemy.course.summary.android.app.R
import udemy.course.summary.android.app.databinding.FragmentPrivacyPoliceBinding

class PrivacyPoliceFragment : Fragment() {

    private lateinit var binding : FragmentPrivacyPoliceBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_privacy_police, container, false)

        binding.btnBackToHome.setOnClickListener {
            it.findNavController().navigate(R.id.action_privacyPoliceFragment_to_homeTrainingFragment)
        }

        return binding.root
    }

}