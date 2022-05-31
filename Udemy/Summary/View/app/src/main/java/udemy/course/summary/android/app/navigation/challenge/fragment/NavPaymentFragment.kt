package udemy.course.summary.android.app.navigation.challenge.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import udemy.course.summary.android.app.R
import udemy.course.summary.android.app.databinding.FragmentNavPaymentBinding

class NavPaymentFragment : Fragment() {

    private lateinit var binding :FragmentNavPaymentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_nav_payment, container, false)

        RadioGroup.OnCheckedChangeListener { group, checkedId ->
            val radio: RadioButton = group.findViewById(checkedId)
            if(radio.id == R.id.rb_payment_McCoin)
                Toast.makeText(context, "You have selected McCoin", Toast.LENGTH_SHORT)
                    .show()
            else if (radio.id == R.id.rb_payment_Paypal)
                Toast.makeText(context, "You have selected ${radio.text}", Toast.LENGTH_SHORT)
                    .show()
            else if (radio.id == R.id.rb_payment_Card)
                Toast.makeText(context, "You have selected ${radio.text}", Toast.LENGTH_SHORT)
                    .show()
            else if (radio.id == R.id.rb_payment_Cash_on_delivery)
                Toast.makeText(context, "You have selected ${radio.text}", Toast.LENGTH_SHORT)
                    .show()

        }

        binding.btnAcceptPayment.setOnClickListener {
            it.findNavController().navigate(R.id.action_navPaymentFragment_to_detailPurcasheFragment)
            Toast.makeText(context, "Payment Accepted", Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }

}