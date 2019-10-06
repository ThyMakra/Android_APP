package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {
    var img = listOf(R.drawable.burger, R.drawable.pizza, R.drawable.fries)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var id = intent.getStringExtra("ID").toInt()

        imageView.setImageResource(img[id])
    }
}
