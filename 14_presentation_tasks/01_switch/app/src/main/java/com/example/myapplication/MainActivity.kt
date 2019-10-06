package com.example.myapplication

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layoutTheme.setBackgroundColor(Color.LTGRAY)

        themeSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                themeSwitch.setTextColor(Color.LTGRAY)
                layoutTheme.setBackgroundColor(Color.BLACK)

                imageV.setImageResource(R.drawable.art03)
            }
            else{
                themeSwitch.setTextColor(Color.BLACK)
                layoutTheme.setBackgroundColor(Color.LTGRAY)

                imageV.setImageResource(R.drawable.art07)
            }
        }
    }
}
