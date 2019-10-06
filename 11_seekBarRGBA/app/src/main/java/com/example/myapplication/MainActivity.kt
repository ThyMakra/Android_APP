package com.example.myapplication

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Alpha.max = 255
        Red.max = 255
        Green.max = 255
        Blue.max = 255
        var myCol = Color.argb(0, 0, 0 ,0)

        class CommonListener: SeekBar.OnSeekBarChangeListener{
            var alp = 0
            var redCol = 0
            var greenCol = 0
            var blueCol = 0

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                when(seekBar?.id){
                    R.id.Alpha -> { alp = progress }
                    R.id.Red -> { redCol = progress }
                    R.id.Green -> { greenCol = progress}
                    R.id.Blue -> { blueCol = progress }
                }
                myCol = Color.argb(alp, redCol, greenCol, blueCol)
//                page.setBackgroundColor(myCol)
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        }

        var common = CommonListener()

        Alpha.setOnSeekBarChangeListener(common)
        Red.setOnSeekBarChangeListener(common)
        Green.setOnSeekBarChangeListener(common)
        Blue.setOnSeekBarChangeListener(common)


        //        buttton only change color when clicked not when progress bar changed
        class ButtonListener: View.OnClickListener{
            override fun onClick(v: View?) {
                when(v?.id){
                    R.id.button1 -> {v.setBackgroundColor(myCol)}
                    R.id.button2 -> {v.setBackgroundColor(myCol)}
                    R.id.button3 -> {v.setBackgroundColor(myCol)}
                    R.id.button4 -> {v.setBackgroundColor(myCol)}
                    R.id.button5 -> {v.setBackgroundColor(myCol)}
                    R.id.button6 -> {v.setBackgroundColor(myCol)}
                    R.id.button7 -> {v.setBackgroundColor(myCol)}
                }
            }

        }

        var buttonClicked = ButtonListener()

        button1.setOnClickListener(buttonClicked)
        button2.setOnClickListener(buttonClicked)
        button3.setOnClickListener(buttonClicked)
        button4.setOnClickListener(buttonClicked)
        button5.setOnClickListener(buttonClicked)
        button6.setOnClickListener(buttonClicked)
        button7.setOnClickListener(buttonClicked)

    }
}
