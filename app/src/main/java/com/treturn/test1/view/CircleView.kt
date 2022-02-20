package com.treturn.test1.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * @CreateDate : 2021/8/19 00:03
 * @Author : 青柠
 * @Description : 画圆
 */
class CircleView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        Paint().run {
            canvas?.let {
                //仅填充内部
                style = Paint.Style.FILL
                color = Color.RED
                strokeWidth = 50F
                it.drawCircle(180F, 180F, 150F, this)

                //填充内部和描边
                style = Paint.Style.STROKE
                color = (0x7EFFFF00)
                it.drawCircle(180F, 180F, 100F, this)

                //仅描边
                style = Paint.Style.FILL_AND_STROKE
                color = Color.BLUE
                it.drawCircle(180F, 180F, 50F, this)
            }
        }

        //贝塞尔曲线
//        val path = Path()
//        path.moveTo(50F,550F)
//        path.quadTo(150F,450F,250F,550F)
//        path.quadTo(350F,650F,450F,550F)
//        canvas?.drawPath(path,paint)
    }
}