package com.treturn.test1.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.treturn.test1.R
import com.treturn.test1.view.ScrollLayoutView
import com.treturn.test1.view.SlideImageView

/**
 * @CreateDate: 2022/2/19 19:33
 * @Author: 青柠
 * @Description:
 */
class SecondFragment : Fragment() {
    private val mSlImage by lazy { activity?.findViewById<SlideImageView>(R.id.slImage) }
    private val mSlView by lazy { activity?.findViewById<ScrollLayoutView>(R.id.slView) }
    private val mClRoot by lazy { activity?.findViewById<ConstraintLayout>(R.id.clRoot) }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initData()
    }

    private fun initView() {
        activity?.let {
            mSlImage?.setOnDragViewClickListener(object : SlideImageView.OnDrawViewClickListener {
                override fun onDragViewClick() {
                    Toast.makeText(it, "Click", Toast.LENGTH_SHORT).show()
                }
            })
        }

    }

    private fun initData() {

    }

}