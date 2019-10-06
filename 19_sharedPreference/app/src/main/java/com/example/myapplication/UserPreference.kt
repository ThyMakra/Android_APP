package com.example.myapplication

import android.content.Context

class UserPreference(context: Context){
//    create filename to store the data
    val FILENAME = "user_preference"

//    store the
//    point to the file where our variable get stored
//    Private Mode will allow variable to on accessed by this application
    val userPreference = context.getSharedPreferences(FILENAME, Context.MODE_PRIVATE)
    val editor = userPreference.edit()

    fun getData(dataName: String): Int{
//        get data(Int) with key-value pair
//        if dataName key not available then return default value 0
        return userPreference.getInt(dataName, 0)
    }

    fun setData(dataName: String, dataValue: Int){
//        store new data to variable
        editor.putInt(dataName, dataValue)
//        finally apply it to file name
        editor.apply()
    }
}