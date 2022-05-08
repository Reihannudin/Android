package udemy.course.android.architecture.navigation.challenge

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import udemy.course.android.architecture.R
import udemy.course.android.architecture.databinding.FragmentHomeChallengeBinding

class HomeChallengeFragment : Fragment() {

    private lateinit var binding : FragmentHomeChallengeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment }
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_challenge, container, false)

        binding.btnSignUp.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeChallengeFragment_to_setNameChallengeFragment)
        }

        binding.btnTerms.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeChallengeFragment_to_termsChallengeFragment)
        }
        return binding.root
    }
}