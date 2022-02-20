package com.treturn.test1.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.treturn.test1.R
import com.treturn.test1.ext.initMain
import com.treturn.test1.ext.interceptLongClick

/**
 * @CreateDate: 2022/2/19 19:33
 * @Author: 青柠
 * @Description:
 */
class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private val mBottomNavigation by lazy { findViewById<BottomNavigationView>(R.id.bottomNavigation) }
    private val mViewPager by lazy { findViewById<ViewPager2>(R.id.viewPager) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initData()
    }

    private fun initView() {
        mBottomNavigation.itemIconTintList = null

        //初始化viewpager2
        mViewPager.initMain(this, mBottomNavigation, false)

        //给底部导航栏菜单项添加点击事件
        mBottomNavigation.setOnNavigationItemSelectedListener(this)

        //拦截BottomNavigation长按事件 防止长按时出现Toast
        mBottomNavigation.interceptLongClick(
            R.id.navigation_main,
            R.id.navigation_second,
            R.id.navigation_third,
            R.id.navigation_four,
            R.id.navigation_five
        )
    }

    private fun initData() {

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.navigation_main -> {
                mViewPager.currentItem = 0
                return true
            }
            R.id.navigation_second -> {
                mViewPager.currentItem = 1
                return true
            }
            R.id.navigation_third -> {
                mViewPager.currentItem = 2
                return true
            }
            R.id.navigation_four -> {
                mViewPager.currentItem = 3
                return true
            }
            R.id.navigation_five -> {
                mViewPager.currentItem = 4
                return true
            }
        }
        return false
    }

}