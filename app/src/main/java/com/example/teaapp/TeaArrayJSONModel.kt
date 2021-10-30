package com.example.teaapp

import com.squareup.moshi.Json

data class TeaArrayJSONModel(

    // Use @SerializedName(" ") for the Gson converter
    // @field:Json(name = " ") for the Moshi converter
    // @SerialName(" ") for the Kotlinx Serialization converter
    // @JsonProperty(" ") for the Jackson converter

    @field:Json(name = "_id")
    var id: String?,

    @field:Json(name = "name")
    var name: String?,

    @field:Json(name = "description")
    var description: String?,

    @field:Json(name = "keywords")
    var keywords: String?,

    @field:Json(name = "origin")
    var origin: String?,

    @field:Json(name = "brew_time")
    var brew_time: Int?,

    @field:Json(name = "temparature")
    var temperature: Int?,
)