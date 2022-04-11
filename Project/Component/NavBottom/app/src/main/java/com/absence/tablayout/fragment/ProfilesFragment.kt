package com.absence.tablayout.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.absence.tablayout.R
import com.absence.tablayout.databinding.FragmentProfilesBinding


class ProfilesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        binding
        val binding = DataBindingUtil.inflate<FragmentProfilesBinding>(inflater,
            R.layout.fragment_profiles,container,false)
        return binding.root
    }

}