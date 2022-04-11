package com.absence.tablayout.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.absence.tablayout.R
import com.absence.tablayout.databinding.FragmentAttendanceBinding

class AttendanceFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        val binding = DataBindingUtil.inflate<FragmentAttendanceBinding>(inflater,
//            R.layout.fragment_attendance,container,false)
//        return binding.root
        return inflater.inflate(R.layout.fragment_attendance,container,false)
    }
}