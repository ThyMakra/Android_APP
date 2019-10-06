package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getSelection.setOnClickListener {
            if (pizza.isChecked){
                Toast.makeText(this, "Pizza selected", Toast.LENGTH_SHORT).show()
                pizza.setChecked(false)
            }
            if (donut.isChecked){
                Toast.makeText(this, "Donut selected", Toast.LENGTH_SHORT).show()
            }
            if(Burger.isChecked){
                Toast.makeText(this, "Burger selected", Toast.LENGTH_SHORT).show()
            }

        }
    }

}
