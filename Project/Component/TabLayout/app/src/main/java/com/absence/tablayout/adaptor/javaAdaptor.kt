/*
package com.absence.tablayout.adaptor

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.absence.tablayout.fragment.AttendanceFragment
import com.absence.tablayout.fragment.MyAttendanceFragment

class javaAdaptor(fm: FragmentManager, private val numOfTabs: Int) : FragmentPagerAdapter(fm) {
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
}*/


/*
package com.absence.tablayout.adaptor;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.absence.tablayout.fragment.AttendanceFragment;
import com.absence.tablayout.fragment.MyAttendanceFragment;

public class javaAdaptor extends FragmentPagerAdapter {

    private int numOfTabs;

    public javaAdaptor(@NonNull FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
            return new AttendanceFragment();
            case 1:
            return new MyAttendanceFragment();
            default:
            return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
*/
