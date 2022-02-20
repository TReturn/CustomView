package com.treturn.test1.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * @CreateDate: 2022/2/19 17:47
 * @Author: 青柠
 * @Description: 直线路径
 */
class LinePathView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        Paint().run {
            canvas?.let {
                color = Color.MAGENTA
                style = Paint.Style.STROKE
                strokeWidth = 5F
                val path = Path().apply {
                    moveTo(20F, 10F)
                    lineTo(20F, 100F)
                    lineTo(300F, 100F)
                    close()
                }
                it.drawPath(path, this)
            }
        }
    }
}