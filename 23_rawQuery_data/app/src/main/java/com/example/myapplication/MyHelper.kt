package com.example.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import java.lang.Exception
import kotlin.math.log

val DB_NAME = "my_db"
val TABLE_NAME = "staff"
val COLUMN1 = "name"
val COLUMN2 = "city"

class MyHelper(context: Context): SQLiteOpenHelper(context, DB_NAME, null, 1){
    var context = context
    override fun onCreate(db: SQLiteDatabase?) {
        try{
            var create_table = "CREATE TABLE $TABLE_NAME($COLUMN1 varchar(250), $COLUMN2 varchar(250))"

            db?.execSQL(create_table)
        }
        catch (e : Exception){
            Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show()
        }

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}

    fun saveData(dto: Staff): Long{
        var cv = ContentValues()
        cv.put(COLUMN1, dto.name)
        cv.put(COLUMN2, dto.city)
        var db = this.writableDatabase
        var resultCode = db.insert(TABLE_NAME, null, cv)
        db.close()
        return resultCode
    }

    fun readData(option: String, city: String = "") : ArrayList<Staff> {
        var db = this.readableDatabase
        var data_list = ArrayList<Staff>()
        var cursor: Cursor

        if (option == "all") {
            cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
        }
        else{
            cursor = db.rawQuery("SELECT * FROM $TABLE_NAME WHERE $option='$city'", null)
        }

        if (cursor != null){
            if (cursor.moveToFirst()) {
                do {
                    var name = cursor.getString(cursor.getColumnIndex(COLUMN1))
                    var city = cursor.getString(cursor.getColumnIndex(COLUMN2))

                    var s = Staff(name, city)
                    data_list.add(s)
                } while (cursor.moveToNext())
            }
        }
        return data_list
    }
}

