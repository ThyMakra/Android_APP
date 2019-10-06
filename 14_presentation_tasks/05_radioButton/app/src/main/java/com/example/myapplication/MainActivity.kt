package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        radioButtonGroup.setOnClickListener {
            var selectedRadio = radioButtonGroup.checkedRadioButtonId

            when (selectedRadio) {
                R.id.radioButton1 -> {
                    Toast.makeText(this, "1 Selected", Toast.LENGTH_SHORT).show()
                }
                R.id.radioButton2 -> {
                    Toast.makeText(this, "2 Selected", Toast.LENGTH_SHORT).show()
                }
                R.id.radioButton3 -> {
                    Toast.makeText(this, "3 Selected", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
}
