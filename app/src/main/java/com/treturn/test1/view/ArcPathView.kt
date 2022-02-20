package com.treturn.test1.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * @CreateDate: 2022/2/19 17:47
 * @Author: 青柠
 * @Description: 弧线路径
 */
class ArcPathView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        Paint().run {
            canvas?.let {
                color = Color.LTGRAY
                style = Paint.Style.STROKE
                strokeWidth = 5F
                //路径连贯
                val path = Path().apply {
                    moveTo(20F, 20F)
                    val rectF = RectF(100F, 10F, 200F, 100F)
                    arcTo(rectF,0F,90F)
                }
                it.drawPath(path, this)

                //路径不连贯
                val path2 = Path().apply {
                    moveTo(20F, 20F)
                    val rectF = RectF(300F, 10F, 400F, 100F)
                    arcTo(rectF,0F,180F,true)
                }
                it.drawPath(path2, this)
            }
        }
    }
}