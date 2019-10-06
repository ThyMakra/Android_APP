package com.example.testing

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    var helper = MyHelper(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        insert_button.setOnClickListener{
            try{
                var name = name_input.text.toString()
                var city = city_input.text.toString()
                var user = User(city,name)

                if(helper.insert(user)){
                    toast("Sucess")
                }else{
                    toast("fail")
                }
            }catch (e: Exception){
//                Log.d(srin,e.toString())
                toast("${e.toString()}")
            }
        }
        search_button.setOnClickListener{
            textView.text = helper.getAll(city_query.text.toString())
        }
    }
}
fun Context.toast(msg:String){
    Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
}