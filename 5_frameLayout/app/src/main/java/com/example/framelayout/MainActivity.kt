package com.example.framelayout

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun changeImageView(view: View){
        var img = view as ImageView
        when(img.id){
            R.id.imageView2 -> { imageView3.visibility = View.VISIBLE
            imageView2.visibility = View.GONE}
            R.id.imageView3 -> {
                imageView2.visibility = View.VISIBLE
                imageView3.visibility = View.GONE}

        }

    }
}
