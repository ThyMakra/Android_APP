package com.example.books

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        next.setOnClickListener(){
            var page_no = Integer.parseInt(page.text.toString())

        }
    }

    fun changeImage(view: View){

        var img = view as ImageView
        when(img.id){

        }
    }
}
