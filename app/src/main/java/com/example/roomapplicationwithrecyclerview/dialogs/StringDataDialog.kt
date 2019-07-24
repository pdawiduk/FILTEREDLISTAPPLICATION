package com.example.roomapplicationwithrecyclerview.dialogs

import android.app.Dialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.roomapplicationwithrecyclerview.MainFragment
import com.example.roomapplicationwithrecyclerview.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.string_value_dialog.*




class StringDataDialog : DialogFragment(){

    private val TAG = StringDataDialog::class.java.simpleName
    private lateinit var  rootView:View

    private var fragment:MainFragment? = null

    private var inputValue = ""

    private var columnName:String = ""

    private lateinit var tvValue:TextView

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        super.onCreateDialog(savedInstanceState)


        initViews()
        var alertDialog: AlertDialog = AlertDialog.Builder(context!!)
            .setView(rootView)
            .setTitle(TITLE_OF_DIALOG)
            .setCancelable(false)
            .setPositiveButton(POSITIVE_BUTTON_TEXT,null)
            .create()

        alertDialog.setCanceledOnTouchOutside(true)
        alertDialog.setCancelable(false)
        alertDialog.setOnShowListener {
            onDialogShow(alertDialog)
        }

        return alertDialog
    }

    private fun initViews() {
        rootView = LayoutInflater.from(context)
            .inflate(R.layout.string_value_dialog,null,false)

        tvValue = rootView.findViewById(R.id.value)
    }


    private fun onDialogShow(dialog: AlertDialog){

        var positiveButton: Button = dialog.getButton(AlertDialog.BUTTON_POSITIVE)
        positiveButton.setOnClickListener {
            onDoneClicked()
        }
    }

    private fun onDoneClicked(){


        inputValue = tvValue.text.toString()
        Log.i(TAG, " INPUT VALUE ====" + inputValue)
       when(columnName){


               USER_COLUMN_NAME -> fragment!!.filterByUser(inputValue)
               LOCAL_COLUMN_NAME -> fragment!!.filterByLocalName(inputValue)
               NAME_COLUMN_NAME -> fragment!!.filterByName(inputValue)

       }

        dismiss()
    }



    companion object{

        private val USER_COLUMN_NAME = "USER"

        private val LOCAL_COLUMN_NAME = "LOCAL"

        private val NAME_COLUMN_NAME = "NAME"

        private val TITLE_OF_DIALOG = "Wpisz Wartość"

        private val POSITIVE_BUTTON_TEXT = "OK"


        fun newInstance( activity:MainFragment,columnName:String): StringDataDialog{

            var dialog = StringDataDialog()
            dialog.fragment = activity
            dialog.columnName =columnName
            return dialog

        }
    }

}