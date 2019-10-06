package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        create an object for class UserPreference, pass MainActivity as the context
        val userPreference = UserPreference(this@MainActivity)
//       get data with key "score"
        var currentScore = userPreference.getData("score")
        score.text = currentScore.toString()

        currentScore += 1
//  call setData method to store the variable with key score and value currentScore
        userPreference.setData("score", currentScore)
    }
}
