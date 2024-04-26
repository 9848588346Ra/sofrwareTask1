package com.example.task1

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private val language= arrayOf("Nepali","Hindi","English","Chinese")
    private lateinit var autoComplete: AutoCompleteTextView
    lateinit var button : Button
    lateinit var textView: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        autoComplete = findViewById(R.id.autoCompleteTextView)

        val autocompleteAdapter = ArrayAdapter(this,
            android.R.layout.simple_dropdown_item_1line,language
        )
        autoComplete.setAdapter(autocompleteAdapter)
        autoComplete.threshold= 1
        autoComplete.setAdapter(autocompleteAdapter)
        autoComplete.threshold= 1
        Toast.makeText(applicationContext, "Display is here", Toast.LENGTH_LONG).show();
        button = findViewById(R.id.buttondatepicker)
        textView = findViewById(R.id.datepicker)

        button.setOnClickListener{
            loadCalender()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun loadCalender() {
        var c = Calendar.getInstance()
        var year = c.get(Calendar.YEAR)
        var month = c.get(Calendar.MONTH)
        var day = c.get(Calendar.DAY_OF_MONTH)

        var dateDialog = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener()
            {datepicker, yy,mm,dd ->
                textView.text = "$yy/$mm/$dd"
            },
            year,month,day)
        dateDialog.show()

    }
}