package com.example.myapplication

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.VideoView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fileLocation = "android.resource://" + packageName + "/raw/" + R.raw.song
//
        val display = findViewById<View>(R.id.videoView) as VideoView

        display.setVideoURI(Uri.parse(fileLocation))
        display.setMediaController(MediaController(this))
        display.start()
    }
}
