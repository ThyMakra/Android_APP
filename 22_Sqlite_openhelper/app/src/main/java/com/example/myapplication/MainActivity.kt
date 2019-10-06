package com.example.myapplication

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

//    button onClick method
    fun insert(v: View){
//    create object with string in the 2 input boxes
        var dto = Staff(city.text.toString(), name.text.toString())
//    SQLiteOpenHelper object
        var helper = MyHelper(this)

        var res = helper.saveData(dto)
//    if fails to insert data, return -1 (Long)
        if (res == -1.toLong()){
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
        }
//        if not return the row number
        else{
            Toast.makeText(this, "New row added at $res", Toast.LENGTH_SHORT).show()
        }
    }
}

