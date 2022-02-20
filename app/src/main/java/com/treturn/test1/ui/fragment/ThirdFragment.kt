package com.treturn.test1.ui.fragment

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Guideline
import androidx.fragment.app.Fragment
import com.treturn.test1.R

/**
 * @CreateDate: 2022/2/19 19:33
 * @Author: 青柠
 * @Description:
 */
class ThirdFragment : Fragment(), View.OnClickListener {
    private val mBtnScale by lazy { activity?.findViewById<Button>(R.id.btnScale) }
    private val mBtnRotation by lazy { activity?.findViewById<Button>(R.id.btnRotation) }
    private val mBtnTranslation by lazy { activity?.findViewById<Button>(R.id.btnTranslation) }
    private val mBtnAlpha by lazy { activity?.findViewById<Button>(R.id.btnAlpha) }
    private val mGuideline by lazy { activity?.findViewById<Guideline>(R.id.guideline) }
    private val mIvLoading by lazy { activity?.findViewById<ImageView>(R.id.ivLoading) }
    private val mClRoot by lazy { activity?.findViewById<ConstraintLayout>(R.id.clRoot) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {

    }

    override fun onStart() {
        super.onStart()
        mBtnAlpha?.setOnClickListener(this)
        mBtnTranslation?.setOnClickListener(this)
        mBtnRotation?.setOnClickListener(this)
        mBtnScale?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnAlpha -> {
                //透明度：alpha
                ObjectAnimator.ofFloat(mIvLoading, "alpha", 1F, 0F, 1F).run {
                    duration = 2000
                    start()
                }
            }
            R.id.btnTranslation -> {
                //平移：translationX，translationY
                val mIvLoadingX = mIvLoading!!.translationX
                ObjectAnimator.ofFloat(mIvLoading, "translationX", mIvLoadingX, -200F, mIvLoadingX)
                    .run {
                        duration = 1000
                        start()
                    }
            }
            R.id.btnRotation -> {
                //旋转：rotation，rotationX,rotationY
                ObjectAnimator.ofFloat(mIvLoading, "rotation", 0F, 360F).run {
                    duration = 1000
                    //循环次数：ValueAnimator.INFINITE无限循环，可传入Int值
                    repeatCount = 1
                    start()
                }
            }
            R.id.btnScale -> {
                //缩放：scaleX，scaleY
                ObjectAnimator.ofFloat(mIvLoading, "scaleX", 1F,3F, 1F).run {
                    duration = 2000
                    start()
                }
            }
        }
    }

}