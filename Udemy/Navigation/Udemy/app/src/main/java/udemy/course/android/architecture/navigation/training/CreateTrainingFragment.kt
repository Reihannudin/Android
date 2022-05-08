package udemy.course.android.architecture.navigation.training

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import udemy.course.android.architecture.R
import udemy.course.android.architecture.databinding.FragmentCreateTrainingBinding

class CreateTrainingFragment : Fragment() {

    private lateinit var binding : FragmentCreateTrainingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_create_training, container, false)

        return FragmentCreateTrainingBinding.inflate(inflater, container, false).root
    }
}
