package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.style.ClickableSpan
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var sign = "X"
    var turn = 0
    var winner = ""
    var win = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun reset(b: Button, click: Boolean){
        b.isClickable = click
        if (click) b.text = ""
    }
//    --------------------------------------------------------------
    fun click (it: View){
        var bt = it as Button
        sign = if (turn%2 == 0) "X" else "O"
        turn++
        when(bt.id){
        R.id.b1, R.id.b2, R.id.b3, R.id.b4, R.id.b5, R.id.b6, R.id.b7, R.id.b8, R.id.b9 -> {
            bt.text = sign
            bt.isClickable = false
            checkWin(b1, b2, b3)
            checkWin(b4, b5, b6)
            checkWin(b7, b8, b9)
            checkWin(b1, b4, b7)
            checkWin(b1, b5, b9)
            checkWin(b2, b5, b8)
            checkWin(b3, b6, b9)
            checkWin(b3, b5, b7)
            if(!win && turn == 9){
                Toast.makeText(this, "the match is a draw", Toast.LENGTH_SHORT).show()
            }
        }
        R.id.reset -> {
            turn = 0
            winner = ""
            win = false
            reset(b1, true)
            reset(b2, true)
            reset(b3, true)
            reset(b4, true)
            reset(b5, true)
            reset(b6, true)
            reset(b7, true)
            reset(b8, true)
            reset(b9, true)
        }
    }
    }
    fun checkWin(b1: Button, b2: Button, b3: Button){
        var a = b1.text.toString()
        var b = b2.text.toString()
        var c = b3.text.toString()
        if ( a==b && a == c && a!=""){
            winner = a
            win = true
            Toast.makeText(this, "$winner won the match", Toast.LENGTH_SHORT).show()
            reset(b1, false)
            reset(b2, false)
            reset(b3, false)
            reset(b4, false)
            reset(b5, false)
            reset(b6, false)
            reset(b7, false)
            reset(b8, false)
            reset(b9, false)
        }
    }
}
