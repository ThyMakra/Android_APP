package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        register for context menu so that we can use "onContextItemSelected" method
//        registerForContextMenu(tv)

        registerForContextMenu(action)

//        when click the button, show a pop up menu
        action.setOnClickListener {
            var popUp = PopupMenu(this, it)
            popUp.inflate(R.menu.my_menu)
            popUp.show()
//            lambda
            // this method require a Boolean return value
            popUp.setOnMenuItemClickListener { menuItem ->
                when(menuItem.itemId){
                    R.id.op1 -> {Toast.makeText(this, "System.out.println(\"Hello World!\")", Toast.LENGTH_SHORT).show()
                        true}
                    R.id.op2 -> {Toast.makeText(this, "print(\"Hello World!\")", Toast.LENGTH_SHORT).show()
                        true}
                    R.id.op3 -> {Toast.makeText(this, "console.log(\"Hello World!\")", Toast.LENGTH_SHORT).show()
                        true}
                    else -> {false}
                }
            }
        }
    }
/*
    override fun onContextItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId)
        {
            R.id.op1->{
                Toast.makeText(this, "System.out.println(\"Hello World\")", Toast.LENGTH_SHORT).show()
            }
            R.id.op2->{
                Toast.makeText(this, "print('Hello World')", Toast.LENGTH_SHORT).show()
            }
            R.id.op3->{
                Toast.makeText(this, "console.log('Hello World')", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onContextItemSelected(item)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.my_menu, menu)
    }*/



}
