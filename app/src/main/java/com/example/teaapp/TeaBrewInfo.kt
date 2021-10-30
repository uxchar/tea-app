package com.example.teaapp

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class TeaBrewInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tea_brew_info)
        parseJSON()

        val actionBar = supportActionBar
        actionBar!!.title = "Tea Brewing Info"

        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


    //Retrofit API Data Parsing
    private fun parseJSON() {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://tea-api-vic-lo.herokuapp.com/#")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        val service = retrofit.create(TAPIService::class.java)
        CoroutineScope(Dispatchers.IO).launch {

            val response = service.listTea()

            withContext(Dispatchers.Main) {
                var userTeaChoice = intent.getStringExtra("tea_selection")
                var tea_name = findViewById<TextView>(R.id.teaName)
                var tea_description = findViewById<TextView>(R.id.teaDescription)
                var tea_keywords = findViewById<TextView>(R.id.teaKeywords)
                var tea_origin = findViewById<TextView>(R.id.teaOrigin)
                var tea_brew_time = findViewById<TextView>(R.id.teaBrewTime)
                var tea_brew_temp = findViewById<TextView>(R.id.teaBrewTemp)


                if (response.isSuccessful) {
                    val data = response.body()
                    if (data != null) {
                        if (userTeaChoice == "Green") {
                            tea_name.setText(data[0].name)
                            tea_description.setText(data[0].description)
                            tea_keywords.setText(data[0].keywords)
                            tea_origin.setText(data[0].origin)
                            tea_brew_time.setText(data[0].brew_time.toString())
                            tea_brew_temp.setText(data[0].temperature.toString())

                        } else if (userTeaChoice == "Black") {
                            tea_name.setText(data[1].name)
                            tea_description.setText(data[1].description)
                            tea_keywords.setText(data[1].keywords)
                            tea_origin.setText(data[1].origin)
                              tea_brew_time.setText(data[1].brew_time.toString())
                              tea_brew_temp.setText(data[1].temperature.toString())
                        } else if (userTeaChoice == "Chamomile") {
                            tea_name.setText(data[2].name)
                            tea_description.setText(data[2].description)
                            tea_keywords.setText(data[2].keywords)
                            tea_origin.setText(data[2].origin)
                            tea_brew_time.setText(data[2].brew_time.toString())
                            tea_brew_temp.setText(data[2].temperature.toString())
                        } else if (userTeaChoice == "Hibiscus") {
                            tea_name.setText(data[3].name)
                            tea_description.setText(data[3].description)
                            tea_keywords.setText(data[3].keywords)
                            tea_origin.setText(data[3].origin)
                            tea_brew_time.setText(data[3].brew_time.toString())
                            tea_brew_temp.setText(data[3].temperature.toString())
                        } else if (userTeaChoice == "Jasmine") {
                            tea_name.setText(data[4].name)
                            tea_description.setText(data[4].description)
                            tea_keywords.setText(data[4].keywords)
                            tea_origin.setText(data[4].origin)
                            tea_brew_time.setText(data[4].brew_time.toString())
                            tea_brew_temp.setText(data[4].temperature.toString())
                        } else if (userTeaChoice == "Mate") {
                            tea_name.setText(data[5].name)
                            tea_description.setText(data[5].description)
                            tea_keywords.setText(data[5].keywords)
                            tea_origin.setText(data[5].origin)
                            tea_brew_time.setText(data[5].brew_time.toString())
                            tea_brew_temp.setText(data[5].temperature.toString())
                        } else if (userTeaChoice == "Oolong") {
                            tea_name.setText(data[6].name)
                            tea_description.setText(data[6].description)
                            tea_keywords.setText(data[6].keywords)
                            tea_origin.setText(data[6].origin)
                            tea_brew_time.setText(data[6].brew_time.toString())
                            tea_brew_temp.setText(data[6].temperature.toString())
                        } else if (userTeaChoice == "Pu-erh") {
                            tea_name.setText(data[7].name)
                            tea_description.setText(data[7].description)
                            tea_keywords.setText(data[7].keywords)
                            tea_origin.setText(data[7].origin)
                            tea_brew_time.setText(data[7].brew_time.toString())
                            tea_brew_temp.setText(data[7].temperature.toString())
                        } else if (userTeaChoice == "Peppermint") {
                            tea_name.setText(data[8].name)
                            tea_description.setText(data[8].description)
                            tea_keywords.setText(data[8].keywords)
                            tea_origin.setText(data[8].origin)
                            tea_brew_time.setText(data[8].brew_time.toString())
                            tea_brew_temp.setText(data[8].temperature.toString())
                        } else if (userTeaChoice == "Rooibos") {
                            tea_name.setText(data[9].name)
                            tea_description.setText(data[9].description)
                            tea_keywords.setText(data[9].keywords)
                            tea_origin.setText(data[9].origin)
                            tea_brew_time.setText(data[9].brew_time.toString())
                            tea_brew_temp.setText(data[9].temperature.toString())
                        } else if (userTeaChoice == "White") {
                            tea_name.setText(data[10].name)
                            tea_description.setText(data[10].description)
                            tea_keywords.setText(data[10].keywords)
                            tea_origin.setText(data[10].origin)
                            tea_brew_time.setText(data[10].brew_time.toString())
                            tea_brew_temp.setText(data[10].temperature.toString())
                        } else if (userTeaChoice == "Yellow") {
                            tea_name.setText(data[11].name)
                            tea_description.setText(data[11].description)
                            tea_keywords.setText(data[11].keywords)
                            tea_origin.setText(data[11].origin)
                            tea_brew_time.setText(data[11].brew_time.toString())
                            tea_brew_temp.setText(data[11].temperature.toString())
                        }

                        }
//                        for (i in 0 until data.count()) {
//                            // Tea ID
//                            val id = data[i].id ?: "N/A"
//                            Log.d("ID: ", id)
//
//                            // Tea Name
//                            val name = data[i].name ?: "N/A"
//                            Log.d("Name: ", name)
//
//                            // Tea Description
//                            val description = data[i].description ?: "N/A"
//                            Log.d("Description: ", description)
//
//                            // Tea Keywords
//                            val keywords = data[i].keywords ?: "N/A"
//                            Log.d("Keywords: ", keywords)
//                        }

                    } else {
                        Log.e("RETROFIT_ERROR", response.code().toString())
                    }


                }
            }
    }
}




