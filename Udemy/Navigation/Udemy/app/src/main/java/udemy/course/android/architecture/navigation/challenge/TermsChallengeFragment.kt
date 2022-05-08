package udemy.course.android.architecture.navigation.challenge

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import udemy.course.android.architecture.R
import udemy.course.android.architecture.databinding.FragmentTermsChallengeBinding

class TermsChallengeFragment : Fragment() {
    private lateinit var binding : FragmentTermsChallengeBinding
    override fun onCreateView(inflater: android.view.LayoutInflater, container: android.view.ViewGroup?,
                              savedInstanceState: android.os.Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_terms_challenge, container, false)
        return binding.root
    }
}