package com.example.myapplication

import android.app.IntentService
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.Toast

//assisting thread
class MyService : IntentService("Daemon") {

//    create Thread for Intent services
    override fun onHandleIntent(intent: Intent?) {
        Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show()
        Log.d("Daemon", "We Are Doing Something")
        Log.d("Daemon", "We Are Doing Other Thing")
        Thread.sleep(1000)
//        Toast.makeText(MainActivity, "Task over", Toast.LENGTH_SHORT).show()
        Toast.makeText(this, "Task over", Toast.LENGTH_SHORT).show()
//        Toast.makeText(this, "Task over", Toast.LENGTH_SHORT).show()
//        Toast.makeText(this, "Task over", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "Service destroyed", Toast.LENGTH_SHORT).show()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show()
        Thread.sleep(10000)
        Toast.makeText(this, "Task over", Toast.LENGTH_SHORT).show()

        return super.onStartCommand(intent, flags, startId)
    }

//    override fun onBind(intent: Intent): IBinder {}
}
