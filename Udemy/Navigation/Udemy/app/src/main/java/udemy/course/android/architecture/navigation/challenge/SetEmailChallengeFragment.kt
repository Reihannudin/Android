package udemy.course.android.architecture.navigation.challenge

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import udemy.course.android.architecture.R
import udemy.course.android.architecture.databinding.FragmentSetEmailChallegeBinding

class SetEmailChallengeFragment : Fragment() {
    private lateinit var binding : FragmentSetEmailChallegeBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSetEmailChallegeBinding.inflate(inflater, container, false)

        binding.btnFrSetEmailChallengeSubmit.setOnClickListener {
            val inputName = requireArguments().getString("input_name")

            if (!TextUtils.isEmpty(binding.etFrSetEmailChallenge.text.toString())){
                val bundleEmail = bundleOf("input_email" to binding.etFrSetEmailChallenge.text.toString(), "input_name" to inputName)
                it.findNavController().navigate(R.id.action_setEmailChallengeFragment_to_viewDataChallegeFragment, bundleEmail)
            } else{
                Toast.makeText(activity, "Please enter email", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }
}