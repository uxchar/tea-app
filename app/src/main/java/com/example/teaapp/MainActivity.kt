package com.example.teaapp

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.teaapp.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        parseJSON()

        val spinner: Spinner = findViewById(R.id.static_spinner)
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


    private fun parseJSON() {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://tea-api-vic-lo.herokuapp.com/#")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        val service = retrofit.create(TAPIService::class.java)
        CoroutineScope(Dispatchers.IO).launch {

            val response = service.listTea()

            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    val items = response.body()
                    if (items != null) {
                        for (i in 0 until items.count()) {
                            // Tea ID
                            val id = items[i].id ?: "N/A"
                            Log.d("ID: ", id)

                            // Tea Name
                            val name = items[i].name ?: "N/A"
                            Log.d("Name: ", name)

                            // Tea Description
                            val description = items[i].description ?: "N/A"
                            Log.d("Description: ", description)

                            // Tea Keywords
                            val keywords = items[i].keywords ?: "N/A"
                            Log.d("Keywords: ", keywords)

                        }
                    }
                } else {
                    Log.e("RETROFIT_ERROR", response.code().toString())
                }
            }
        }
    }
}


