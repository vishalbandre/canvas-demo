package com.bitcolon.canvasdemo

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
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

    private val path: Path = Path()

    private var dX: Float = 0.0f
    private var dY: Float = 0.0f

    // Shapes
    private val shapeValues = arrayOf("line", "triangle", "square", "rectangle", "circle")

    // Tools
    private val toolValues = arrayOf("pen", "eraser")

    // Colors
    private val colorValues = arrayOf("black", "red", "green", "blue", "yellow", "white")

    // Modes
    private val modeValues = arrayOf("draw", "erase")

// Current mode
    var mode: Int = 0
        set(value) {
            field = value
            invalidate()
        }

    // Current shape
    var shape: Int = 0
        set(value) {
            field = value
            invalidate()
        }

    // Current tool
    var tool: Int = 0
        set(value) {
            field = value
            invalidate()
        }

    // Current color

    var color: Int = 0
        set(value) {
            field = value
            invalidate()
        }

    // Current size
    var size: Int = 0
        set(value) {
            field = value
            invalidate()
        }

    // Current alpha
    var alpha: Int = 0
        set(value) {
            field = value
            invalidate()
        }

    // Current fill
    var fill: Boolean = false
        set(value) {
            field = value
            invalidate()
        }

    // Current stroke
    var stroke: Boolean = false
        set(value) {
            field = value
            invalidate()
        }

    // Current stroke width
    var strokeWidth: Int = 0
        set(value) {
            field = value
            invalidate()
        }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        setupPaint()

        Log.d("CustomView", "onDraw: $mode")

        when (mode) {
            0 -> {
                canvas.drawPath(path, paint)
                Log.d("CustomView", "onDraw: Pen")
            }
            1 -> {
                canvas.drawCircle(dX, dY, 50f, paint)
                Log.d("CustomView", "onDraw: Circle")
            }
            2 -> {
                canvas.drawColor(Color.WHITE)
            }
        }
        canvas.drawPath(path, paint)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                dX = event.rawX
                dY = event.rawY
                if (mode == 0) {
                    path.moveTo(dX, dY)
                }
            }
            MotionEvent.ACTION_MOVE -> {
                dX = event.rawX
                dY = event.rawY
                if (mode == 0) {
                    path.lineTo(dX, dY)
                }
            }
        }
        postInvalidate()
        return true
    }

    private fun setupPaint() {
        paint.color = Color.BLUE
        paint.isAntiAlias = true
        paint.strokeWidth = 5F
        paint.style = Paint.Style.FILL_AND_STROKE
        paint.strokeJoin = Paint.Join.ROUND
        paint.strokeCap = Paint.Cap.ROUND
        paint.style = Paint.Style.STROKE
    }
}