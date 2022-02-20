package com.treturn.test1.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

/**
 * @CreateDate: 2022/2/19 17:47
 * @Author: 青柠
 * @Description: 画矩形
 */
class RectView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        Paint().run {
            canvas?.let {
                color = Color.CYAN
                style = Paint.Style.STROKE
                strokeWidth = 10F
                //直接构造
                it.drawRect(50F, 10F, 150F, 110F, this)
                //使用RectF构造
                style = Paint.Style.FILL_AND_STROKE
                val rect = RectF(200F, 10F, 300F, 110F)
                it.drawRect(rect, this)
            }
        }
    }
}