package com.bitcolon.canvasdemo

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var customView: CustomView

    private lateinit var btnColorRed: Button
    private lateinit var btnColorGreen: Button
    private lateinit var btnColorBlue: Button

    // Get PreferenceManager
//    val sharedPref : SharedPreferences = getSharedPreferences("com.bitcolon.canvasdemo", Context.MODE_PRIVATE)

//    private lateinit var constraintLayout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        customView = CustomView(this)

        btnColorRed = findViewById(R.id.btnColorRed)
        btnColorGreen = findViewById(R.id.btnColorGreen)
        btnColorBlue = findViewById(R.id.btnColorBlue)

        val sharedPref = getSharedPreferences("com.bitcolon.canvasdemo", Context.MODE_PRIVATE)

        btnColorRed.setOnClickListener {
            // Add color in shared preferences
            with(sharedPref.edit()) {
                putInt("color", Color.RED)
                apply()
            }
        }

        btnColorGreen.setOnClickListener {
            // Add color in shared preferences
            with(sharedPref.edit()) {
                putInt("color", Color.GREEN)
                apply()
            }
        }

        btnColorBlue.setOnClickListener {
            // Add color in shared preferences
//            with(sharedPref.edit()) {
//                putInt("color", Color.BLUE)
//                apply()
//            }
        }
    }


}