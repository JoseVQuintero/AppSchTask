package com.joe.appschtask.adapter.pager

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.joe.appschtask.fragment.tasktype.AttendFragment
import com.joe.appschtask.fragment.tasktype.JustifyFragment
import com.joe.appschtask.fragment.tasktype.today.TodayFragment

class TabsTask (
    fm: FragmentManager,
    lifecycle: Lifecycle,
    private var numberOfTabs: Int) : FragmentStateAdapter(fm, lifecycle)
{
    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> {
                // # Music Fragment
                val bundle = Bundle()
                bundle.putString("fragmentName", "Today Fragment")
                val todayFragment = TodayFragment()
                todayFragment.arguments = bundle
                return todayFragment
            }
            1 -> {
                // # Movies Fragment
                val bundle = Bundle()
                bundle.putString("fragmentName", "Attend Fragment")
                val attendFragment = AttendFragment()
                attendFragment.arguments = bundle
                return attendFragment
            }
            2 -> {
                // # Books Fragment
                val bundle = Bundle()
                bundle.putString("fragmentName", "Justify Fragment")
                val justifyFragment = JustifyFragment()
                justifyFragment.arguments = bundle
                return justifyFragment
            }
            else -> return TodayFragment()
        }
    }

    override fun getItemCount(): Int {
        return numberOfTabs
    }

}