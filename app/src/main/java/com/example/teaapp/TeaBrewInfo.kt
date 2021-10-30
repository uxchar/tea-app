package com.example.teaapp

import android.os.Bundle
import android.util.Log
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
////    var userTeaChoice = intent.getStringExtra("selectedTea")
////    fun teaSelect() {
////        if (userTeaChoice == "Green") {
//
//        }
//    }
//}