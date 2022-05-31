package udemy.course.summary.android.app.navigation.training.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import udemy.course.summary.android.app.R
import udemy.course.summary.android.app.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    private lateinit var binding : FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)

        val getInputFirstName =  requireArguments().getString("input_firstName")
        val getInputLastName = requireArguments().getString("input_lastName")
        val getInputEmail = requireArguments().getString("input_email")
        val getInputPassword = requireArguments().getString("input_password")
        val getInputPhone = requireArguments().getString("input_phoneNumber")
        val getInputBirthday = requireArguments().getString("input_birthday")

        binding.tvDetailFirstName.text = getInputFirstName.toString()
        binding.tvDetailLastName.text = getInputLastName.toString()
        binding.tvDetailEmail.text = getInputEmail.toString()
        binding.tvDetailPassword.text = getInputPassword.toString()
        binding.tvDetailPhoneNumber.text = getInputPhone.toString()
        binding.tvDetailBirthday.text = getInputBirthday.toString()

        binding.btnBackToHome.setOnClickListener {
            it.findNavController().navigate(R.id.action_detailFragment_to_homeTrainingFragment)
        }

        binding.btnPrivacyPolicy.setOnClickListener {
            it.findNavController().navigate(R.id.action_detailFragment_to_privacyPoliceFragment)
        }

        return binding.root
    }
}