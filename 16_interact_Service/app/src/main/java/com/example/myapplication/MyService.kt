package com.example.myapplication

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import java.util.*

class MyService : Service() {

    inner class MyBinder:Binder(){
//        Binder() that bind the service, to client
        fun get_service_obj() : MyService{
//    when call the service, return the Service
            return this@MyService
        }
    }

    var binder : Binder = MyBinder()

//    when bind the service, return the Binder
    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    fun getTime() : String{
        return Date().toString()
    }
}
