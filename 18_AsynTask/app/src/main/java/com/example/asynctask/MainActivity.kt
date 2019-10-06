package com.example.asynctask

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun startDownload(v: View){
//        pass context, button_id, progressBar_id, textView_id to MyTask class
        var myTask = MyTask(this, button, progressBar, status)
        myTask.execute()
    }
}
