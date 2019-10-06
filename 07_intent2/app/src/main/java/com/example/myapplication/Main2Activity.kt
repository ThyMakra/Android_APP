package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    fun goHome(v: View){
        var i = Intent()
//        pass some text from input field
        var username = editText.text.toString()

        i.putExtra("data", username)
//        setResult(Activity.RESULT_OK,i)
        setResult(Activity.RESULT_OK)
        finish()
//        finish() will kill the 2nd activity so "startActivityForResult()" in activity 1 will execute
    }
}
