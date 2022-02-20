package com.treturn.test1.ui.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.treturn.test1.R

/**
 * @CreateDate: 2022/2/19 19:33
 * @Author: 青柠
 * @Description:
 */
class MainFragment : Fragment() {
    private val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
    private val TAG = "MainLog"
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initData()
    }

    private fun initView() {

    }

    private fun initData() {

    }

    //with函数
    private fun withFun() {
        val result = with(StringBuilder()) {
            for (fruit in list) {
                append(fruit).append("\n")
            }
            toString()
        }
        Log.d(TAG, "withFun: $result")
    }

    //run函数
    private fun withRun() {
        val result = StringBuilder().run {
            for (fruit in list) {
                append(fruit).append("\n")
            }
            toString()
        }
        Log.d(TAG, "withFun: $result")
    }

    //apply函数
    private fun withApply() {
        val result = StringBuilder().apply {
            for (fruit in list) {
                append(fruit).append("\n")
            }
        }
        //apply函数无法指定返回值
        Log.d(TAG, "withFun: ${result.toString()}")
    }

    //拓展String函数
    private fun String.lettersCount(): Int {
        var count = 0
        for (char in this) {
            if (char.isLetter()) {
                count++
            }
        }
        return count
    }

}