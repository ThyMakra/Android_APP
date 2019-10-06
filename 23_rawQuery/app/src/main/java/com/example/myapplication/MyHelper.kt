package com.example.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.sax.StartElementListener

val DB_NAME = "my_db"
val TABLE_NAME = "staff"
val COLUMN1 = "name"
val COLUMN2 = "city"

class MyHelper(context: Context): SQLiteOpenHelper(context, DB_NAME, null, 1){
    override fun onCreate(db: SQLiteDatabase?) {
        var create_table = "create table $TABLE_NAME ($COLUMN1 varchar(250), $COLUMN2 varchar(250))"

        db?.execSQL(create_table)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}

    fun saveData(dto: Staff): Long{
        var cv = ContentValues()
        cv.put(COLUMN1, dto.name)
        cv.put(COLUMN2, dto.city)
        var db = this.writableDatabase
        var result_code = db.insert(TABLE_NAME, null, cv)
        return result_code
    }

    fun readData(city: String) : ArrayList<Staff>{
        var db = this.readableDatabase
//        create an array list to store all the objects
        var data_list = ArrayList<Staff>()

        var cursor = db.rawQuery("select * from staff where city = $city", null)
        if (cursor != null || cursor!!.moveToFirst()){
            do {
                var name = cursor.getString(cursor.getColumnIndex(COLUMN1))
                var city = cursor.getString(cursor.getColumnIndex(COLUMN2))

                var s = Staff(city, name)
                data_list.add(s)
            }while (cursor.moveToNext())
        }
        return data_list
    }
}