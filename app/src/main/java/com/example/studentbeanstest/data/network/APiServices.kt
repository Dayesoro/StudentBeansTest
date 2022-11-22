package com.example.studentbeanstest.data.network

import com.example.studentbeanstest.data.model.StudentBeansResponse
import retrofit2.http.GET

interface APiServices {

    @GET("photos")
    suspend fun fetchData():StudentBeansResponse
}