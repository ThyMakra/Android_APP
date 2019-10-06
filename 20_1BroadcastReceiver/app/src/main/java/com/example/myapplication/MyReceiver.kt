package com.example.myapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver: BroadcastReceiver(){

    override fun onReceive(context: Context?, intent: Intent?) {
//        this method is called when the BroadcastReceiver is receiving an intent broadcast
        Toast.makeText(context, "Hello I am making this", Toast.LENGTH_LONG).show()

    }
}