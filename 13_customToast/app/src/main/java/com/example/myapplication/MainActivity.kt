package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

//  button onclick method in activity_main
    fun showToast(v: View){
        var myview = layoutInflater.inflate(R.layout.custom_toast, null)

        var myToast = Toast(this)
        myToast.duration =  Toast.LENGTH_SHORT
        myToast.setGravity(Gravity.BOTTOM, 0, 40)

        myToast.view = myview
        myToast.show()
    }
}