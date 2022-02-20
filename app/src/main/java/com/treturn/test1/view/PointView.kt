package com.treturn.test1.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * @CreateDate: 2022/2/19 17:47
 * @Author: 青柠
 * @Description: 画点
 */
class PointView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        Paint().run {
            color = Color.BLUE
            strokeWidth = 15F
            canvas?.let {
                it.drawPoint(40F, 20F, this)
                it.drawPoint(60F, 20F, this)
                it.drawPoint(80F, 20F, this)
            }
        }
    }
}