package com.absence.tablayout.viewmodel


import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.absence.tablayout.R
import com.absence.tablayout.adaptor.PagerAdaptor
import com.absence.tablayout.databinding.FragmentPagerBinding
import com.absence.tablayout.fragment.PagerFragment
import com.google.android.material.tabs.TabLayout

class HomeViewModel(fragmentPager : Fragment) : ViewModel() {

    var binding: FragmentPagerBinding = DataBindingUtil.inflate(
        LayoutInflater.from(fragmentPager.context),
        R.layout.fragment_pager,
        null,
        true
    )
}