package com.example.myapplication

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

    var helper = MyHelper(this)

    fun insertData(v: View){
        var dto = Staff(name_input.text.toString(), city_input.text.toString())

        var res = helper.saveData(dto)
        if (res == -1.toLong()){
            Toast.makeText(this, "Failed to insert data", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this, "New row added at $res", Toast.LENGTH_LONG).show()
        }
    }

    fun searchData(v: View){
//        take the "city" string, then query it from database
        var data_list = helper.readData(city_query.text.toString())
// get all the objects in data_list
        var string = ""
        for (data in data_list){
            string += "\t Name: ${data.name} \n\t City: ${data.city} \n"
        }
        textView.text = string
    }
}
