package com.example.teaapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
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
        val img = findViewById<ImageView>(R.id.teaLadyLogo)
        val title = findViewById<TextView>(R.id.teaTitle)
        val question = findViewById<TextView>(R.id.teaBrewText)
        val animation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        //starting the animation
        img.startAnimation(animation)
        title.startAnimation(animation)
        question.startAnimation(animation)
        teaDropDown()

    }



//Drop down menu for user tea selection
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
//Code for select button to continue to next screen when pushed
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val button: Button = findViewById(R.id.selectButton)
        val selectedTea = parent?.getItemAtPosition(position).toString()
        if(selectedTea == "Choose Tea Type"){

            } else{
            var text = "You selected $selectedTea tea, please press Select to continue"
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, text, duration)
            toast.show()
            button.setOnClickListener {
                if (selectedTea == "Choose Tea Type") {
                    text = "Please choose a tea type to continue"
                    toast.show()
                } else {
                    val intent = Intent(this, TeaBrewInfo::class.java)
                    intent.putExtra("tea_selection", selectedTea)
                    startActivity(intent)
                }
            }
    }
    }



        override fun onNothingSelected(parent: AdapterView<*>) {
            // Another interface callback
        }

    }


