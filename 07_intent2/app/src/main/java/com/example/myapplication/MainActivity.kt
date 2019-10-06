package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun callB(v: View){
        var i = Intent(this, Main2Activity::class.java)
        startActivityForResult(i, 2)

//  startActivityForResult(), it starts other activity and wait for result, to start this activity again
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==2){
            var str = data?.getStringExtra("data")
            user.text = str
        }
    }
}
