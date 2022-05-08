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
import udemy.course.android.architecture.R
import udemy.course.android.architecture.databinding.FragmentSetNameChallegeBinding

class SetNameChallengeFragment : Fragment() {
    private lateinit var binding : FragmentSetNameChallegeBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSetNameChallegeBinding.inflate(inflater, container, false)

        binding.btnFrSetNameChallengeSubmit.setOnClickListener {
            if(!TextUtils.isEmpty(binding.etFrSetNameChallenge.text.toString())){
                val bundleName = bundleOf("input_name" to binding.etFrSetNameChallenge.text.toString())
                it.findNavController().navigate(R.id.action_setNameChallengeFragment_to_setEmailChallengeFragment, bundleName)
            } else{
                Toast.makeText(activity, "Please enter your name", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }
}