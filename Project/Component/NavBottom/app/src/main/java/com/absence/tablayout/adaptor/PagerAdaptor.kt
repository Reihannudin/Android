package com.absence.tablayout.adaptor


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.absence.tablayout.fragment.AttendanceFragment
import com.absence.tablayout.fragment.MyAttendanceFragment


class PagerAdaptor(fm : FragmentManager, private var numOfTabs : Int) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> AttendanceFragment()
            1 -> MyAttendanceFragment()
            else -> null!!
        }
    }

    override fun getCount(): Int {
        return numOfTabs
    }
}

