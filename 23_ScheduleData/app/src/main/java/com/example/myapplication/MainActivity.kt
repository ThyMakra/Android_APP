package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView.setOnTouchListener(object: OnSwipeTouchListener(this){
            override fun swipeLeft() {
                super.swipeLeft()
                Toast.makeText(this@MainActivity, "Swipe Left", Toast.LENGTH_LONG).show()
//                var i = Intent(this@MainActivity, Main2Activity::class.java)
//                startActivity(i)
            }
            override fun swipeRight() {
                Log.e("ViewSwipe", "Right")
            }
//            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
//                Log.d("DEBUG_TAG", "GestureDetector"+gestureDetector.toString())
//                gestureDetector.onTouchEvent(event)
//                return false
//            }
        })
    }
}
