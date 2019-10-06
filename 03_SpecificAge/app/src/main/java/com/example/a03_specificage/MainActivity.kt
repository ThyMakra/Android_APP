package com.example.a03_specificage

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        calculate.setOnClickListener(){
//            var year = yob.text.toString().toInt();
//            var c_year = Calendar.getInstance().get(Calendar.YEAR);
//            var urAge = c_year - year;
//            age.text = "Your age is : $urAge"
//        }
        calculate.setOnClickListener() {
            var yobstr = yob.text.toString()
            var calendarmonth = arrayOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
            var yobarr = yobstr.split("/")
            var date = yobarr[0].toInt()
            var month = yobarr[1].toInt()
            var year = yobarr[2].toInt()
            var c_date = Calendar.getInstance().get(Calendar.DATE)
            var c_month = Calendar.getInstance().get(Calendar.MONTH) + 1
            var c_year = Calendar.getInstance().get(Calendar.YEAR)
            if (c_date < date) {
                if (month == 2) {
                    if (leapyear(year)){
                        c_date = 29 + c_date - date
                    }
                    else{
                        c_date = 28 + c_date - date
                    }
//                    c_date = 28 + c_date - date
                } else {
                    c_date = calendarmonth[month - 1] + c_date - date
                }

                month++
            } else {
                c_date -= date
            }
            if (c_month < month) {
                c_month = 12 + c_month - month
                year++
            } else {
                c_month -= month
            }
            c_year -= year
            age.text = "You have lived for $c_year years $c_month months $c_date days"
        }

    }

}
fun leapyear(year: Int): Boolean{
    return if (year % 4 == 0){
        if (year % 100 == 0) {
            year % 400 == 0
        }
        else true
    }
else false
}
