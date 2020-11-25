package com.twan.kotlinbase.adapter

import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import java.util.*

//使用的是新的 viewpager2
class BottomViewPagerAdapter(@NonNull fragmentActivity: FragmentActivity?, private val mFragments: List<Fragment>) : FragmentStateAdapter(fragmentActivity!!) {
    @NonNull
    override fun createFragment(position: Int): Fragment {
        return mFragments[position]
    }

    override fun getItemCount(): Int {
        return mFragments.size
    }
}