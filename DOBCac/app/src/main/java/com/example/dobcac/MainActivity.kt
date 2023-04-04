package com.example.dobcac

import android.app.DatePickerDialog
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat


class MainActivity : AppCompatActivity() {
    private var tvSelectedDate: TextView?= null
    private var tvAgeMinutes: TextView?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val datePicker: Button = findViewById(R.id.datePick)
        tvSelectedDate = findViewById(R.id.tvSelectedDate)
        tvAgeMinutes = findViewById(R.id.tvDate)
        datePicker.setOnClickListener(){
            datePickerClick()
        }
    }

    private fun datePickerClick(){
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        val dpd = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener{view, year, month, dayOfMonth ->
                Toast.makeText(this, "Year is $year, " +
                        "he month is ${month+1} and the day of the month is $dayOfMonth",
                    Toast.LENGTH_LONG).show()
                val selectedDate = "${month+1}/$dayOfMonth/$year"
                tvSelectedDate?.text = selectedDate
                val sdf = SimpleDateFormat("MM/dd/yyyy")
                val date = sdf.parse(selectedDate)
                date?.let {
                    val dateInMinutes = date.time/ 60000
                    val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                    currentDate?.let {
                        val currentDateInMinutes = currentDate.time / 60000
                        val differnceTime = currentDateInMinutes - dateInMinutes
                        tvAgeMinutes?.text=differnceTime.toString()
                    }
                }
            },
            year,
            month,
            day
        )
        dpd.datePicker.maxDate= System.currentTimeMillis() - 86400000
        dpd.show()

    }
}