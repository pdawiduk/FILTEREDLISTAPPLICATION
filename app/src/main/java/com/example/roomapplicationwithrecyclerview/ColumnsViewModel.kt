package com.example.roomapplicationwithrecyclerview

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.icu.util.Calendar
import android.util.Log
import android.widget.DatePicker
import androidx.lifecycle.ViewModel
import com.example.roomapplicationwithrecyclerview.dialogs.StringDataDialog



class ColumnsViewModel(fragment: MainFragment) : ViewModel(){

    val TAG = ColumnsViewModel::class.java.simpleName
    val fragment = fragment
    val context = fragment.requireContext()


    fun hourCliked(){
        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR)
        val minute = c.get(Calendar.MINUTE)

        val hourPicker = TimePickerDialog(context,TimePickerDialog.OnTimeSetListener(function = { view, h, m ->


            fragment.fiterByHour((h.toString() + ":" + m.toString() ))

        }),hour,minute,true)

        hourPicker.show()
    }
    fun dateClicked(){

        val c = Calendar.getInstance()
        val day = c.get(Calendar.DAY_OF_MONTH)
        val month = c.get(Calendar.MONTH)
        val year = c.get(Calendar.YEAR)

        val datePicker = DatePickerDialog(context,DatePickerDialog.OnDateSetListener(function = { view, d, m, y ->

            fragment.filterByDate(m.toString() + "-" + d.toString())

        }),month, year,day)

        datePicker.show()


    }




    fun stringClicked(

        columnName:String){

        Log.i(TAG,"String clicked " + columnName)

        when(columnName){
            USER_COLUMN_NAME -> fragment.showDialog(columnName)
            LOCAL_COLUMN_NAME -> fragment.showDialog(columnName)
            NAME_COLUMN_NAME -> fragment.showDialog(columnName)
        }

    }

    companion object{

        private val USER_COLUMN_NAME = "USER"

        private val LOCAL_COLUMN_NAME = "LOCAL"

        private val NAME_COLUMN_NAME = "NAME"
    }


}