package com.example.myapplication

import android.gesture.Gesture
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.GestureDetectorCompat
import android.view.GestureDetector
import android.view.MotionEvent
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener{
    var gdc:GestureDetectorCompat? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gdc = GestureDetectorCompat(this, this)
        gdc?.setOnDoubleTapListener(this)
    }

    override fun onShowPress(e: MotionEvent?) {
        tv.text = "show press"
        page.setBackgroundColor(Color.BLUE)
    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        tv.text = "Tap up..."
        page.setBackgroundColor(Color.GREEN)
        return true
    }

    override fun onDown(e: MotionEvent?): Boolean {
        tv.text = "Key Down"
        page.setBackgroundColor(Color.YELLOW)
        return true
    }

    override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
        tv.text = "Flinging..."
        page.setBackgroundColor(Color.GRAY)
        return true
    }

    override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
        tv.text = "scrolling"
        page.setBackgroundColor(Color.DKGRAY)
        return true
    }

    override fun onLongPress(e: MotionEvent?) {
        tv.text = "on long press.."
        page.setBackgroundColor(Color.GREEN)
    }

    override fun onDoubleTap(e: MotionEvent?): Boolean {
        tv.text = "double tap"
        page.setBackgroundColor(Color.RED)
        return true
    }

    override fun onDoubleTapEvent(e: MotionEvent?): Boolean {
        tv.text = "double tap"
        page.setBackgroundColor(Color.BLUE)
        return true
    }

    override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
        tv.text = "single tap"
        page.setBackgroundColor(Color.BLUE)
        return true
    }



//    swipe left/right



}
