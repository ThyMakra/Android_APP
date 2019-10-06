package com.example.myapplication

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        set seekBars' max value
        transparentSB.max = 255
        redSB.max = 255
        greenSB.max = 255
        blueSB.max = 255

        class CommonListener: SeekBar.OnSeekBarChangeListener{
// create a class, so we can an object to pass to "setOnSeekBarChangeListener"
            var transparent = 0
            var red = 0
            var green = 0
            var blue = 0

            override fun onProgressChanged(seekBar: SeekBar?, p1: Int, p2: Boolean) {
                when(seekBar?.id) {
//      with specific id, store the value to different variables
                    R.id.transparentSB -> {transparent = p1}
                    R.id.redSB -> {red = p1}
                    R.id.greenSB -> {green = p1}
                    R.id.blueSB -> {blue = p1}
                }
//                color class
                var sbColor = Color.argb(transparent, red, green, blue)
//                set the color background to the page
                myPage.setBackgroundColor(sbColor)

//                set the textView color contrast to background color
                var tColor = Color.argb(transparent, 255-red, 255-green, 255 - blue)
                textView.setTextColor(tColor)
//                show the RGBA values
                textView.text = "RGBA($red, $green, $blue, $transparent)"
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                // Do Nothing
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                // Do Nothing
            }
        }

        var commonListener = CommonListener()
        transparentSB.setOnSeekBarChangeListener(commonListener)
        redSB.setOnSeekBarChangeListener(commonListener)
        greenSB.setOnSeekBarChangeListener(commonListener)
        blueSB.setOnSeekBarChangeListener(commonListener)
    }
}
