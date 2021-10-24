package com.example.teaapp

import retrofit2.Response
import retrofit2.http.GET

interface TAPIService {
    @GET("/tea")
    suspend fun listTea(): Response<List<TeaArrayJSONModel>>
}