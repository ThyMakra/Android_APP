package com.example.startnewactivity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        /*var user = intent.getStringExtra("username")
        var school = intent.getStringArrayExtra("school")

        myText.text = "The name, $user, should you find me @ $school"*/

        var bundle = intent.extras
        myText.text = "User = ${bundle?.get("name")} and school = ${bundle?.get("school")}"
    }
}
