package com.treturn.test1.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * @CreateDate: 2022/2/19 17:47
 * @Author: 青柠
 * @Description: 画线
 */
class LineView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        Paint().run {
            color = (0xFFFF0000.toInt())
            style = Paint.Style.FILL_AND_STROKE
            strokeWidth = 10F
            canvas?.drawLine(20F, 20F, 400F, 20F, this)
            canvas?.drawLine(20F, 40F, 400F, 40F, this)
        }
    }
}