package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import android.R.attr.button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var player = 1
    private var sign = "X"
    private var turn = 0
    private var winner = ""
    private var win = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun reset (b : Button, click: Boolean){
        b.isClickable = click
        if (click)  b.text = ""

    }
    fun winCheck(b1: Button, b2:Button, b3:Button){
        var a = b1.text.toString()
        var b = b2.text.toString()
        var c = b3.text.toString()
        if (a== b && a == c && a != ""){
            winner = a
            win =true
            Toast.makeText(this, "$winner win the match", Toast.LENGTH_SHORT).show()
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
    fun click (it:View){
        var k = it as Button
        sign = if (player%2 ==1) "X" else "O"
        player++
        turn++
        when (k.id){
            R.id.b1, R.id.b2, R.id.b3, R.id.b4, R.id.b5, R.id.b6, R.id.b7, R.id.b8, R.id.b9-> {
                k.text = sign
                k.isClickable = false
                winCheck(b1, b2, b3)
                winCheck(b4, b5, b6)
                winCheck(b7, b8, b9)
                winCheck(b1, b5, b9)
                winCheck(b1, b4, b7)
                winCheck(b2, b5, b8)
                winCheck(b3, b6, b9)
                winCheck(b3, b5, b7)
                if (!win && turn==9){
                    Toast.makeText(this, "the match is a draw", Toast.LENGTH_SHORT).show()
                }
            }
            R.id.reset ->{
                player = 1
                winner =""
                win = false
                turn = 0
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
}
