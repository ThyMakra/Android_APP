package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.GestureDetectorCompat
import android.view.GestureDetector
import android.view.View
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {
    var helper = MyHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        myTable.setOnClickListener{ myTable.setColumnCollapsed(1, !myTable.isColumnCollapsed(1)) }
        buttonActivity2.setOnClickListener{ startActivity(Intent(this, MainActivity::class.java)) }
    }

    fun searchData(v: View){
        var data_list: ArrayList<Staff> = ArrayList()
        when(v.id){
            R.id.searchCity -> { data_list = helper.readData("city", city_query.text.toString()) }
            R.id.searchAll -> { data_list = helper.readData("all") }
        }
        myTable.removeAllViews()
        myTable.addView(createRow(TableRow(this), "Name", "City", true))
        for (data in data_list){
            myTable.addView(createRow(TableRow(this), data.name, data.city))
        }
    }

    //function to add more row
    private fun createRow(row: TableRow, col1: String, col2: String, isHeader: Boolean = false): TableRow {
        var params = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT)
        params.setMargins(1, 0, 1, 0)

        row.layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT)
        var textView1 = TextView(this)
        textView1.layoutParams = params
        textView1.setText(col1)
        textView1.textAlignment = View.TEXT_ALIGNMENT_CENTER

        var textView2 = TextView(this)
        textView2.layoutParams = params
        textView2.setText(col2)
        textView2.textAlignment = View.TEXT_ALIGNMENT_CENTER
        textView2.layoutParams.width = 300

        if (isHeader){
            textView1.setBackgroundColor(Color.parseColor("#c6c6c6"))
            textView2.setBackgroundColor(Color.parseColor("#c6c6c6"))
        }

        row.addView(textView1, 0)
        row.addView(textView2, 1)
        row.setBackgroundColor(Color.parseColor("#f1f1f1"))
        return row
    }




}
