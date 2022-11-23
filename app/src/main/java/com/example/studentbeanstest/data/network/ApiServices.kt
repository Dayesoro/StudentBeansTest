package com.example.studentbeanstest.data.network

import com.example.studentbeanstest.data.network.Response.StudentBeansResponseList
import retrofit2.http.GET

interface ApiServices {

    @GET("photos")
    suspend fun fetchData():StudentBeansResponseList
}