package com.absence.tablayout.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.absence.tablayout.R
import com.absence.tablayout.databinding.FragmentCreateBinding


class CreateFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        binding
        val binding = DataBindingUtil.inflate<FragmentCreateBinding>(inflater,
            R.layout.fragment_create,container,false)
        return binding.root

    }

}