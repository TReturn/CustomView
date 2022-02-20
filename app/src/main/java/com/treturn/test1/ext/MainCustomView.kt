package com.treturn.test1.ext

import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.treturn.test1.R
import com.treturn.test1.ui.fragment.*

/**
 * @CreateDate : 2021/8/8 0:18
 * @Author : 青柠
 * @Description :
 */

/**
 * 首页底部导航栏ViewPager2初始化
 * @receiver ViewPager2
 * @param fragment FragmentActivity
 * @return ViewPager2
 */
fun ViewPager2.initMain(
    fragment: FragmentActivity,
    bottomNavigationView: BottomNavigationView,
    isUserInputEnabled: Boolean
): ViewPager2 {
    //是否可滑动
    this.isUserInputEnabled = isUserInputEnabled
    this.offscreenPageLimit = 5
    //设置适配器
    adapter = object : FragmentStateAdapter(fragment) {
        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> {
                    MainFragment()
                }
                1 -> {
                    SecondFragment()
                }
                2 -> {
                    ThirdFragment()
                }
                3 -> {
                    FourFragment()
                }
                else -> {
                    FiveFragment()
                }
            }
        }

        override fun getItemCount() = 5
    }
    if (isUserInputEnabled) {
        registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    0 -> {
                        bottomNavigationView.selectedItemId = R.id.navigation_main
                    }
                    1 -> {
                        bottomNavigationView.selectedItemId = R.id.navigation_second
                    }
                    2 -> {
                        bottomNavigationView.selectedItemId = R.id.navigation_third
                    }
                    3 -> {
                        bottomNavigationView.selectedItemId = R.id.navigation_four
                    }
                    else -> {
                        bottomNavigationView.selectedItemId = R.id.navigation_five
                    }
                }
            }
        })
    }
    return this
}

/**
 * 拦截BottomNavigation长按事件 防止长按时出现Toast
 * @receiver BottomNavigationView
 * @param ids IntArray
 */
fun BottomNavigationView.interceptLongClick(vararg ids: Int) {
    val bottomNavigationMenuView: ViewGroup = (this.getChildAt(0) as ViewGroup)
    for (index in ids.indices) {
        bottomNavigationMenuView.getChildAt(index).findViewById<View>(ids[index])
            .setOnLongClickListener {
                true
            }
    }
}