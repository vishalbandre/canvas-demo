package com.bitcolon.canvasdemo

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View


class CustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var paint: Paint = Paint()

    private var dX: Float = 0.0f
    private var dY: Float = 0.0f

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        setupPaint()
//        canvas.save()
//        canvas.drawCircle(dX, dY, 5f, paint)
//        canvas.restore()

        // Paint on move
        canvas.drawCircle(dX, dY, 5f, paint)
        Log.d("New Values: ", "dX: $dX, dY: $dY")

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        invalidate();
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                dX = event.rawX
                dY = event.rawY
//                invalidate()
            }
            MotionEvent.ACTION_MOVE -> {
                dX = event.rawX
                dY = event.rawY
//                invalidate()
            }
        }
        return true
    }

    private fun setupPaint() {
        paint.color = Color.BLUE
        paint.isAntiAlias = true
        paint.strokeWidth = 5F
        paint.style = Paint.Style.FILL_AND_STROKE
        paint.strokeJoin = Paint.Join.ROUND
        paint.strokeCap = Paint.Cap.ROUND
    }
}