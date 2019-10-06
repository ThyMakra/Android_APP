package com.mixkie.ebook

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pageHolder.setImageResource(R.drawable.photo1)

        pageHolder.setOnClickListener {
            goToPage.clearFocus()
        }
    }


    var pages = listOf(R.drawable.photo1, R.drawable.photo2, R.drawable.photo3, R.drawable.photo4, R.drawable.photo5)
    var pageIndex = 0

    fun changePage(view: View) {
        var pageToGo = goToPage.text.toString()
        var tv = view as TextView

        when(tv.id) {
            R.id.previousButton -> {
                if(pageIndex <= 0)
                    pageIndex = pages.size - 1
                else
                    pageIndex--
            }

            R.id.nextButton -> {
                if(pageIndex >= pages.size - 1)
                    pageIndex = 0
                else
                    pageIndex++
            }

            R.id.goButton -> {
                if (pageToGo.isEmpty())
                    return
                else if (pageToGo.toInt() < 0  || pageToGo.toInt() > pages.size - 1) {
                    Toast.makeText(this, "Invalid Page Number. There's only ${pages.size} pages.", Toast.LENGTH_SHORT).show()
                }
                else {
                    pageIndex = pageToGo.toInt()
                    goToPage.text.clear()
                }
            }
        }
        pageHolder.setImageResource(pages[pageIndex])
        goToPage.clearFocus()
    }
}
