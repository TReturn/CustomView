package com.treturn.test1.view

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.treturn.test1.log.LogUtils
import com.treturn.test1.qmui.QMUIDisplayHelper

/**
 * @CreateDate : 2021/8/25 21:01
 * @Author : 青柠
 * @Description : 跟随手指轨迹的滑动自定义View
 */
class ScrollLayoutView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private var lastX: Int = 0
    private var lastY: Int = 0

    private var maxRight = 0
    private var maxBottom = 0

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        val x = event.x.toInt()
        val y = event.y.toInt()

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                lastX = x
                lastY = y

                //获取屏幕宽、高,且只赋一次值
                if (maxRight == 0) {
                    maxRight = QMUIDisplayHelper.getScreenWidth(context)
                    maxBottom = (QMUIDisplayHelper.getScreenHeight(context)/1.12).toInt()
                }

            }
            MotionEvent.ACTION_MOVE -> {
                //计算移动距离
                val offsetX = x - lastX
                val offsetY = y - lastY

                //根据事件的偏移来移动imageView
                var left: Int = left + offsetX
                var top: Int = top + offsetY
                var right: Int = right + offsetX
                var bottom: Int = bottom + offsetY

                //限制left  >=0
                if (left < 0) {
                    right += -left
                    left = 0
                }
                //限制top
                if (top < 0) {
                    bottom += -top
                    top = 0
                }
                //限制right <= maxRight
                if (right > maxRight) {
                    left -= right - maxRight;
                    right = maxRight
                }
                //限制bottom <= maxBottom
                if (bottom > maxBottom) {
                    top -= bottom - maxBottom;
                    bottom = maxBottom
                }

                //调用layout来重新放置它的位置
                layout(left, top, right, bottom)
            }
        }
        return true
    }

}