package com.absence.fragment.ui.main.viewmodel

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.viewpager.widget.ViewPager
import com.absence.fragment.databinding.ActivityMainBinding
import com.absence.fragment.ui.main.SectionsPagerAdapter
import com.google.android.material.tabs.TabLayout

class HomeViewModel : ViewModel() {
    private val _index = MutableLiveData<Int>()
    val text: LiveData<String> = Transformations.map(_index) {
        "Hello world from section: $it"
    }




    fun setIndex(index: Int) {
        _index.value = index
    }
}