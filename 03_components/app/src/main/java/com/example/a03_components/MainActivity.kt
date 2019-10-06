package com.example.a03_components

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonClicked(view:View) {
//        Toast.makeText(this, "Button Clicked....", Toast.LENGTH_LONG).show()
        var button = view as Button
        when(button.id){
            //R = res
            R.id.button1 -> Toast.makeText(this, " my id is button 1", Toast.LENGTH_LONG).show()
            R.id.button2 -> Toast.makeText(this, "my id is button 2", Toast.LENGTH_LONG).show()
            else -> Toast.makeText(this, "this button id is not specified", Toast.LENGTH_LONG).show()
        }
    }
}
