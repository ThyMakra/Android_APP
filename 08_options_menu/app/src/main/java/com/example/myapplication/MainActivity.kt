package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        var intent = Intent(this, Main2Activity::class.java)
        when(item?.itemId){
            R.id.op1 -> {
                Toast.makeText(this, "You have order Pizza", Toast.LENGTH_LONG)
                intent.putExtra("ID",0)
                startActivity(intent)
            }
            R.id.op2 -> {
                Toast.makeText(this, "You have order Burger", Toast.LENGTH_LONG)
                intent.putExtra("ID",1)
                startActivity(intent)
            }
            R.id.op3 -> {
                Toast.makeText(this, "You have order French Fries", Toast.LENGTH_LONG)
                intent.putExtra("ID",2)
            }
        }
        startActivity(intent)

        return super.onOptionsItemSelected(item)
    }
}
