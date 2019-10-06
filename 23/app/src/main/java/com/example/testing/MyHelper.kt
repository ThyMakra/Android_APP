package com.example.testing

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
var DB_NAME = "users"
var TABLE_NAME = "user"
var NAME = "name"
var CITY ="city"
class MyHelper(context: Context):SQLiteOpenHelper(context,DB_NAME,null,1){
    override fun onCreate(db: SQLiteDatabase?) {
        var create_table = "create table $TABLE_NAME ($NAME varchar(250), $CITY varchar(250))"
        db?.execSQL(create_table)
    }

    fun  insert(user:User):Boolean{
        var cv = ContentValues()
        cv.put(NAME, user.name)
        cv.put(CITY, user.city)
        var db = this.writableDatabase
        var resultCode = db.insert(TABLE_NAME, null, cv)
        db.close()
        return Integer.parseInt("$resultCode") != -1
    }

    fun getAll(city: String):String{
        var allUser = ""
        var db = readableDatabase
        var selectAll = "select * from $TABLE_NAME where $CITY='$city'"
        var cursor = db.rawQuery(selectAll,null)
        if (cursor != null){
            if(cursor.moveToFirst()){
                do{
                    var name = cursor.getString(cursor.getColumnIndex(NAME))
                    var city = cursor.getString(cursor.getColumnIndex(CITY))
                    allUser = "$allUser\n $name $city"
                }while(cursor.moveToNext())
            }
        }
        return allUser
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}

}