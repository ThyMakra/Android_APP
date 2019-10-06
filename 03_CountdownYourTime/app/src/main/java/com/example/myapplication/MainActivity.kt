package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        generate.setOnClickListener(){
            label1.text = "#1\n"+(50..100).random().toString()
            label2.text = "#2\n"+(50..100).random().toString()
            label3.text = "#3\n"+(50..100).random().toString()
            label4.text = "#4\n"+(50..100).random().toString()

            var total = label1.text.toString().toInt() + label2.text.toString().toInt() + label3.text.toString().toInt() + label4.text.toString().toInt()
            label5.text = "Expected age left\n${total/4}"
            val timer = object : CountDownTimer(59000, 1){
                override fun onTick(millisUntilFinished: Long) {
                    countdown.setText("seconds remaining: ${millisUntilFinished/1000}")
//                    countdown.text = "time left: ${millisUntilFinished/1000}"
                }

                override fun onFinish() {
                    countdown.setText("Good bye!")
//                    countdown.text = "Time finished"
                }
            }
            timer.start()

//            countdown.text =
        }
    }
}
