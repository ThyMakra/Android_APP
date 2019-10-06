package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    lateinit var i: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        create an intent
        i = Intent(this, MyService::class.java)
    }
//    button onclick methods
    fun start(v:View){
        startService(i)
    }
    fun stop(v: View){
        stopService(i)
    }
}
