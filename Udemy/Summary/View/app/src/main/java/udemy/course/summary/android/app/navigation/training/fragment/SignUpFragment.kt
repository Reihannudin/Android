package udemy.course.summary.android.app.navigation.training.fragment

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import udemy.course.summary.android.app.R
import udemy.course.summary.android.app.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {

    private lateinit var binding : FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up, container, false)

        binding.btnSubmit.setOnClickListener {
//
            if (!TextUtils.isEmpty(binding.etInputFirstName.text.toString()) && !TextUtils.isEmpty(binding.etInputLastName.text.toString())
                && !TextUtils.isEmpty(binding.etInputEmail.text.toString()) && !TextUtils.isEmpty(binding.etInputPassword.text.toString())
                && !TextUtils.isEmpty(binding.etInputPhoneNumber.text.toString()) && !TextUtils.isEmpty(binding.etInputBirthday.text.toString()))
            {
                val bundle = bundleOf(
                    "input_firstName"  to binding.etInputFirstName.text.toString(),
                    "input_lastName" to binding.etInputLastName.text.toString(),
                    "input_email" to binding.etInputEmail.text.toString(),
                    "input_password" to binding.etInputPassword .text.toString(),
                    "input_phoneNumber" to binding.etInputPhoneNumber.text.toString(),
                    "input_birthday" to  binding.etInputBirthday.text.toString()
                )
                it.findNavController().navigate(R.id.action_signUpFragment_to_detailFragment, bundle)
            }else{
                Toast.makeText(activity, "column cannot be empty, please complete all columns", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnBack.setOnClickListener {
            it.findNavController().navigate(R.id.action_signUpFragment_to_homeTrainingFragment)
        }
        return binding.root
    }
}