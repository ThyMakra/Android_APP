package com.example.myapplication

import android.app.Service
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

// client - service_connection <-> ServiceBinder - Service

class MainActivity : AppCompatActivity() {
//Bound service.
//    Create an object from "MyService" class
    var serviceObject: MyService? = null
//    create ServiceConnection object.
    var service_connection: ServiceConnection = object :ServiceConnection{

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
//            type casting
//            call the method in class Binder inside the service
            var binder : MyService.MyBinder = service as MyService.MyBinder
//          so when the service connected, the Binder will return the Service "MyService"
            serviceObject = binder.get_service_obj()

        }
        override fun onServiceDisconnected(name: ComponentName?) {}
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        connect from 'this = here'
        var i = Intent(this, MyService::class.java)
//        Context.BIND_AUTO_CREATE : specify how to connect to service
        bindService(i, service_connection, Context.BIND_AUTO_CREATE)
    }
//    a button method
    fun getService(){
        textV.text = serviceObject?.getTime()
    }
}
