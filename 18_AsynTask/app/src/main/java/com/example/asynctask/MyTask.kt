package com.example.asynctask

import android.content.Context
import android.os.AsyncTask
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

// AsyncTask class
class MyTask(context: Context, button: Button, proressBar: ProgressBar, status: TextView): AsyncTask<Void, Int, String>() {
    lateinit var context: Context
    lateinit var button: Button
    lateinit var progressBar: ProgressBar
    lateinit var status: TextView

    init {
        this.context = context
        this.button = button
        this.progressBar = progressBar
        this.status = status
    }
    override fun onPreExecute() {
        status.text = "Preparing for Download"
        Thread.sleep(1000)
        button.isEnabled = false
    }

    override fun doInBackground(vararg p0: Void?): String {
        for(i in 1..100 step 1) {
            Thread.sleep(100)
            publishProgress(i)
        }
        return "Download Completed !!"
    }

    override fun onProgressUpdate(vararg values: Int?) {
        var progress = values[0]
        progressBar.progress = progress!!
        status.text = "$progress % until Complete"
    }

    override fun onPostExecute(result: String?) {
        status.text = result
        button.isEnabled = true
    }
}