package udemy.course.summary.android.app.viewmodels

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import udemy.course.summary.android.app.R
import udemy.course.summary.android.app.databinding.ActivityMainFirstVmactivityBinding
import udemy.course.summary.android.app.viewmodels.viewmodel.FirstVMViewModel
import udemy.course.summary.android.app.viewmodels.viewmodel.factory.FirstVMViewModelFactory

class MainFirstVMActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainFirstVmactivityBinding
    private lateinit var firstViewModel : FirstVMViewModel
    private lateinit var firstViewModelFactory : FirstVMViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main_first_vmactivity)

        firstViewModelFactory= FirstVMViewModelFactory(1.8)

        firstViewModel = ViewModelProvider(this,firstViewModelFactory).get(FirstVMViewModel::class.java)

        firstViewModel.moneyLiveData.observe(this, Observer {
            binding.tvValueBalance.text = it.toString()
        })

        binding.apply {
            tvValueBalance.text = firstViewModel.moneyLiveData.value.toString()
            tvHambugerPrice.text = firstViewModel.getPriceHamburger().toString()
            tvColaPrice.text = firstViewModel.getPriceCola().toString()
        }

        binding.btnCalculateRectangle.setOnClickListener {
            firstViewModel.setTopUpMoney(binding.etInputTopUp.text.toString().toDouble())
//            binding.tvValueBalance.text = firstViewModel.getMoney().toString()

            firstViewModel.moneyLiveData.observe(this@MainFirstVMActivity, Observer {
                binding.tvValueBalance.text = it.toString()
            })
        }

        binding.ibHamburger.setOnClickListener {
            warning()
            binding.tvValueBalance.text = firstViewModel.buyItemHamburger().toString()
//            binding.tvValueBalance.text = firstViewModel.getMoney().toString()

            firstViewModel.moneyLiveData.observe(this@MainFirstVMActivity, Observer {
                binding.tvValueBalance.text = it.toString()
            })
        }

        binding.ibCola.setOnClickListener {
            warning()
            binding.tvValueBalance.text = firstViewModel.buyItemCola().toString()
//            binding.tvValueBalance.text = firstViewModel.getMoney().toString()

            firstViewModel.moneyLiveData.observe(this@MainFirstVMActivity, Observer {
                binding.tvValueBalance.text = it.toString()
            })
        }

        notMin()
    }

    private fun warning(): String {
        if(binding.tvValueBalance.text.toString().toDouble() <= 0.0){
            if (binding.tvValueBalance.text.toString().toDouble() <= firstViewModel.getPriceHamburger()){
                binding.ibHamburger.isEnabled = false
                Toast.makeText(this,"You don't have enough money",Toast.LENGTH_SHORT).show()
            }
            else if(binding.tvValueBalance.text.toString().toDouble() <= firstViewModel.getPriceCola()){
                binding.ibCola.isEnabled = false
                Toast.makeText(this,"You don't have enough money",Toast.LENGTH_SHORT).show()
            }
        }
        return binding.tvValueBalance.text.toString()
    }


    private fun notMin(){
        if (binding.tvValueBalance.text.toString().toDouble() < 0.0){
            binding.tvValueBalance.text = "0.0"
        }
    }
}