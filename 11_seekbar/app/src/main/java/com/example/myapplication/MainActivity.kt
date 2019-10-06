package com.example.myapplication

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        configure seekBar
        seekBar.max = 255

// anonymous object

        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            //        this method wait for OnSeekBarChangeListener interface


            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                //when ever the seekbar changed
                //progress store the value of the seekBar


            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // only the first time you track the seekBar
                tv.text = "start tracking at ${seekBar?.progress}"
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                tv.text = "stop tracking at ${seekBar?.progress}"
            }

        })

    }
}
