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

    lateinit var bR : BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var ifil = IntentFilter()
        ifil.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        ifil.addAction(Intent.ACTION_BATTERY_CHANGED)

//        var receiver: BroadcastReceiver? = null
//        receiver = MyReceiver()
        bR = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                Toast.makeText(this@MainActivity, "ACTION: ${intent?.action}", Toast.LENGTH_SHORT).show()
            }
        }

        registerReceiver(bR, ifil)

    }

    override fun onDestroy() {
        unregisterReceiver(bR)
        super.onDestroy()
    }

    fun sentMessage(v: View){
        var i = Intent(this, MyReceiver::class.java)
        /*i.action = "com.example.myapplication"
        i.flags = Intent.FLAG_INCLUDE_STOPPED_PACKAGES*/

//        i.action = Intent.ACTION_BATTERY_OKAY
        sendBroadcast(i)
    }
}
