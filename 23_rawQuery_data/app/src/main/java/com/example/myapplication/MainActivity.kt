package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.GestureDetectorCompat
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.*



class MainActivity : AppCompatActivity() {
    var helper = MyHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonActivity.setOnClickListener{ startActivity(Intent(this, Main2Activity::class.java)) }
    }



    fun insertData(v: View){
        var dto = Staff(name_input.text.toString(), city_input.text.toString())

        var res = helper.saveData(dto)
        if (res == -1.toLong()){
            Toast.makeText(this, "Failed to insert data", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this, "New row added at $res", Toast.LENGTH_LONG).show()
        }
    }




}
