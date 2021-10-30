package com.example.teaapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.teaapp.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        teaDropDown()
        val button: Button = findViewById(R.id.selectButton)
        button.setOnClickListener {
            val intent = Intent(this, TeaBrewInfo::class.java)
            startActivity(intent)
        }

    }


    private fun teaDropDown() {
        val spinner: Spinner = findViewById(R.id.static_spinner)
        spinner.onItemSelectedListener = this

// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.tea_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter

        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            val selectedItem = parent?.getItemAtPosition(position).toString()
            val text = "You Selected ${selectedItem} Tea, Please Press Select to Continue"
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, text, duration)
            toast.show()
    }



        override fun onNothingSelected(parent: AdapterView<*>) {
            // Another interface callback
        }

    }


