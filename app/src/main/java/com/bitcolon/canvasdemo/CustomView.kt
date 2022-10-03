package com.bitcolon.canvasdemo

import android.content.Context
import android.content.SharedPreferences
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

    var paint: Paint = Paint()

    private val path: Path = Path()

    private var dX: Float = 0.0f
    private var dY: Float = 0.0f

    // Tools
    private val toolValues = arrayOf("pen", "eraser")
    private val currentToolIndex = 0

    // Colors
    private val colorValues = arrayOf("red", "green", "blue", "yellow", "white", "black")
    public var currentColorIndex = 0

    var color: Int = Color.RED

    // Brushes
    private val brushValues = arrayOf("small", "medium", "large")
    private val currentBrushIndex = 0

    // Brush styles
    private val brushStyleValues = arrayOf("solid", "dashed", "dotted")

    // Get PreferenceManager Instance
    val sharedPref: SharedPreferences = context.getSharedPreferences("com.bitcolon.canvasdemo", Context.MODE_PRIVATE)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        invalidate()
        setupPaint()
//        Log.d("COLOR", color.toString())
        canvas.drawPath(path, paint)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                dX = event.rawX
                dY = event.rawY
                path.moveTo(dX, dY)
            }
            MotionEvent.ACTION_MOVE -> {
                dX = event.rawX
                dY = event.rawY
                path.lineTo(dX, dY)
            }
        }
        postInvalidate()
        return true
    }

    private fun setupPaint() {
        val c = sharedPref.getInt("color", Color.RED)
        Log.d("Current Color: ", c.toString())
        // Get color from shared preferences
//        paint.color = sharedPref.getInt("color", Color.RED)
        paint.color = c
        paint.isAntiAlias = true
        paint.strokeWidth = 5F
        paint.style = Paint.Style.FILL_AND_STROKE
        paint.strokeJoin = Paint.Join.ROUND
        paint.strokeCap = Paint.Cap.ROUND
        paint.style = Paint.Style.STROKE
    }

    public fun newColor(colorCode: Int) {
        color = colorCode
    }
}