package com.example.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

val DB_NAME = "mydb"
val TABLE_NAME = "staff"
val COLUMN1 = "city"
val COLUMN2 = "name"
class MyHelper(context: Context): SQLiteOpenHelper(context, DB_NAME, null, 1){
    override fun onCreate(db: SQLiteDatabase?) {
//  to create table in SQL database and initialize the column
        var table_create = "create table $TABLE_NAME ($COLUMN1 varchar(250), $COLUMN2 varchar(250))"
//        create table
        db?.execSQL(table_create)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun saveData(dto: Staff): Long {
//        create a map to insert to database
        var cv = ContentValues()
        cv.put(COLUMN1, dto.city)
        cv.put(COLUMN2, dto.name)

        var db = this.writableDatabase
        var result_long = db.insert(TABLE_NAME, "city, name", cv)

        return result_long
    }

}