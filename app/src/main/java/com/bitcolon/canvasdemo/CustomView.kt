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
    private var currentShapeIndex = 0

    // Tools
    private val toolValues = arrayOf("pen", "eraser")
    private val currentToolIndex = 0

    // Colors
    private val colorValues = arrayOf("black", "red", "green", "blue", "yellow", "white")
    private val currentColorIndex = 0

    // Brushes
    private val brushValues = arrayOf("small", "medium", "large")
    private val currentBrushIndex = 0

    private var trianglePath: Path? = null

    // constructor() for trianglePath CustomView
    init {
        trianglePath = Path()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        setupPaint()

        Log.d("CustomView", "onDraw: $shapeValues")

        canvas.drawPath(path, paint)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val result = super.onTouchEvent(event)
        if (event.action == MotionEvent.ACTION_DOWN) {
            currentShapeIndex =  (currentShapeIndex ++) % shapeValues.length;
            postInvalidate();
            return true;
        }
        return result;

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