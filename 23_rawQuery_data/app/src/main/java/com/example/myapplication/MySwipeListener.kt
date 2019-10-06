package com.example.myapplication

import android.content.Context
import android.gesture.Gesture
import android.nfc.Tag
import android.os.Debug
import android.support.v4.view.GestureDetectorCompat
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import java.lang.Exception

open class MySwipeListener(context: Context) : View.OnTouchListener {

    var context = context
//    private val gestureDetector =  GestureDetectorCompat(context, GestureListener())
    private val gestureDetector =  GestureDetector(context, GestureListener())

    fun onTouch(event: MotionEvent?) : Boolean {
        return gestureDetector.onTouchEvent(event)
    }
    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        return gestureDetector.onTouchEvent(event)
    }

    private inner class GestureListener : GestureDetector.SimpleOnGestureListener(){
        private val SWIPE_THRESHOLD = 100
        private val SWIPE_VELOCITY_THRESHOLD = 100

        override fun onDown(e: MotionEvent?): Boolean {
            Log.d("DEBUG_TAG", "Down: " + e.toString())
            Toast.makeText(context, "Down", Toast.LENGTH_SHORT).show()
            return super.onDown(e)
        }

        override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
            onTouch(e)
            return super.onSingleTapConfirmed(e)
        }
        /*override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
            Toast.makeText(context, "HI", Toast.LENGTH_SHORT).show()
            var result = false
            if (e1 != null && e2 != null){
                var diffX = e2.x - e1.x
                if(diffX > 0) swipeRight()
                else swipeLeft()
//                result = true
            }
            return result
        }*/
        override fun onFling(e1: MotionEvent, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
            val result = false
            try {
                val diffY = e2.y - e1.y
                val diffX = e2.x - e1.x
                if (Math.abs(diffX) > Math.abs(diffY)) {
                    if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffX > 0) {
                            swipeRight()
                        } else {
                            swipeLeft()
                        }
                    }
                } else {
                    // onTouch(e);
                }
            } catch (exception: Exception) {
                exception.printStackTrace()
            }

            return result
        }
    }
    open fun swipeLeft(){}
    open fun swipeRight(){}
}

/*open class MySwipeListener(context: Context):GestureDetector.SimpleOnGestureListener(){
    override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
        Log.d("DEBUG_TAG", e1.toString() + e2.toString())
        if (e1 != null && e2 != null){
            var diffX = e2.getX() - e1.getX()
        if(diffX > 0) swipeRight()
        else swipeLeft()
        }
        return super.onFling(e1, e2, velocityX, velocityY)
    }

    open fun swipeLeft(){}
    open fun swipeRight(){}
}*/
