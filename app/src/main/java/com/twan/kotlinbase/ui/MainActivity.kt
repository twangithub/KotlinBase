package com.twan.kotlinbase.ui

import android.content.Intent
import androidx.viewpager.widget.ViewPager
import com.twan.kotlinbase.R
import com.twan.kotlinbase.adapter.BottomViewPagerAdapter
import com.twan.kotlinbase.app.BaseActivity
import com.twan.kotlinbase.fragment.Tab1Fragment
import com.twan.kotlinbase.fragment.Tab2Fragment
import com.twan.kotlinbase.fragment.Tab3Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    companion object {
        lateinit var main:MainActivity
    }

    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        var tab = intent?.extras?.getInt("tab")
        if (tab == 2) {
            viewpager.setCurrentItem(2,true)
        } else if (tab ==0) {
            viewpager.setCurrentItem(0,true)
        } else {
            viewpager.setCurrentItem(1,true)
        }
    }

    override fun initEventAndData() {
        setSwipeBackEnable(false)
        main= this
        setContentView(R.layout.activity_main)
        initBottomBar()
    }

    private fun initBottomBar(){
        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.item_tab1 -> {
                    viewpager.currentItem = 0
                    true
                }
                R.id.item_tab2 -> {
                    viewpager.currentItem = 1
                    true
                }
                R.id.item_tab3 -> {
                    viewpager.currentItem = 2
                    true
                }
                else -> false
            }
        }

        setupViewPager(viewpager)

        viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                bottom_navigation.menu.getItem(position).isChecked = true
            }

        })
    }


    private fun setupViewPager(viewPager: ViewPager) {
        var adapter = BottomViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(Tab1Fragment())
        adapter.addFragment(Tab2Fragment())
        adapter.addFragment(Tab3Fragment())
        viewPager.adapter = adapter
    }
}