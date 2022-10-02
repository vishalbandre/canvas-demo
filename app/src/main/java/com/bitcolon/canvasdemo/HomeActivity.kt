package com.bitcolon.canvasdemo

import android.graphics.Canvas
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout

class HomeActivity : AppCompatActivity() {

//    private lateinit var constraintLayout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

//        // Initiate the ImageView and its properties
//        val i = ImageView(this).apply {
//            setImageResource(R.drawable.img1)
//            contentDescription = resources.getString(R.string.image_1_description)
//
//            // Set the ImageView bounds to match the Drawable's dimensions
//            adjustViewBounds = true
//            layoutParams = ViewGroup.LayoutParams(
//                ViewGroup.LayoutParams.WRAP_CONTENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT
//            )
//        }
//
//        // Create a ConstranitLayout in which to add the ImageView
//        constraintLayout = ConstraintLayout(this).apply {
//            addView(i)
//        }
//
//        // Set the layout as the content view
//        setContentView(constraintLayout)
    }
}