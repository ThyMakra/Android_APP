package com.example.myapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var broadcastReceiver: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//      1/ create intentFilter object
        var intentFilter = IntentFilter()
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)

//      2/ create broadcast receiver object
        broadcastReceiver = object: BroadcastReceiver(){
            override fun onReceive(context: Context?, intent: Intent?) {
                Toast.makeText(this@MainActivity, intent?.action, Toast.LENGTH_LONG).show()
            }
        }
//        3/ register receiver with intent filter
        registerReceiver(broadcastReceiver, intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
//        when destroy, unregister the broadcast
        unregisterReceiver(broadcastReceiver)
    }

    fun sendBct(v: View){
        var i = Intent(this, MyReceiver::class.java)
        sendBroadcast(i)
    }

    /*
    Todo(understand this topic)
    system base broadcast (message send by the android to all applications to send
    --- code in android activity
    --- code base handling
    user define broadcast
    --- context base ( more power full)
    --- context base is manifest file
    Todo(system base brodcast)
    1. create intentFilter object  ex Todo( add action like -> battery change....)
    2. create object for brodcast reciever interface Todo(implement fun onReceiver()
    3. function registerRec
 */
}
