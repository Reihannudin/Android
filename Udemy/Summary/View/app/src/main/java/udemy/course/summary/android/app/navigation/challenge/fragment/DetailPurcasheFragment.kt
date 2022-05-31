package udemy.course.summary.android.app.navigation.challenge.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import udemy.course.summary.android.app.R
import udemy.course.summary.android.app.databinding.FragmentDetailPurcasheBinding

class DetailPurcasheFragment : Fragment() {

    private lateinit var binding : FragmentDetailPurcasheBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail_purcashe, container, false)

//        val getFirstNameDetailAddress = requireArguments().getString("firstname")
//        val getLastNameDetailAddress = requireArguments().getString("lastname")
//        val getEmailDetailAddress = requireArguments().getString("email")
//        val getContactDetailAddress = requireArguments().getString("contact")
//        val getAddressDetailAddress =  requireArguments().getString("address")
//        val getRequestDetailAddress =  requireArguments().getString("request")
//
//        binding.tvNameReciever.text = "${getFirstNameDetailAddress.toString()} ${getLastNameDetailAddress.toString()}"
//        binding.tvContactPurchase.text = getContactDetailAddress.toString()
//        binding.tvAddressReciver.text = getAddressDetailAddress.toString()

        return binding.root
    }

}