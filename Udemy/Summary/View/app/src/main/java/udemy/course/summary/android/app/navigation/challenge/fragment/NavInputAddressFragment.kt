package udemy.course.summary.android.app.navigation.challenge.fragment

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
import udemy.course.summary.android.app.databinding.FragmentNavInputAddressBinding

class NavInputAddressFragment : Fragment() {

    private lateinit var binding : FragmentNavInputAddressBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_nav_input_address, container, false)

        binding.btnSetAddress.setOnClickListener {

            if (!TextUtils.isEmpty(binding.etRecervierFirstname.text.toString()) && !TextUtils.isEmpty(binding.etRecervierLastname.text.toString())
                && !TextUtils.isEmpty(binding.etRecervierEmailInformation.text.toString()) && !TextUtils.isEmpty(binding.etRecervierContactInformation.text.toString())
                && !TextUtils.isEmpty(binding.etReciverAddress.text.toString())){

                val bundle = bundleOf(
                    "firstname" to binding.etRecervierFirstname.text.toString(),
                    "lastname" to binding.etRecervierLastname.text.toString(),
                    "email" to binding.etRecervierEmailInformation.text.toString(),
                    "contact" to binding.etRecervierContactInformation.text.toString(),
                    "address" to binding.etReciverAddress.text.toString(),
                    "request" to binding.etAdditionalRequest.text.toString()
                )
                it.findNavController().navigate(R.id.action_navInputAddressFragment2_to_navPaymentFragment, bundle)
            }else{
                Toast.makeText(activity, "column cannot be empty, please complete all columns", Toast.LENGTH_SHORT).show()
            }
        }

        binding.ivBackToOrderPage.setOnClickListener {
            it.findNavController().navigate(R.id.action_navInputAddressFragment2_to_navOrderFragment)
        }

        return binding.root
    }

}