package com.example.startnewactivity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startNewActivity(v:View){
        var intent = Intent(this, Main2Activity::class.java)
//        why do we need to convert that to Java file?
//        convert the kt file into java file -> we want it to convert to "class file"

        // similar to Map has <Key, Value>
        /*
        intent.putExtra("username", "Mark")
        intent.putExtra("school", "TiK")*/

        var bundle = Bundle()
        bundle.putString("name", "Mark")
        bundle.putString("school", "TIK")

        intent.putExtras(bundle)

        startActivity(intent)
    }
}
