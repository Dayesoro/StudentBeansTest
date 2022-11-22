package com.example.studentbeanstest.di

import com.example.studentbeanstest.data.model.StudentBeansResponse
import com.example.studentbeanstest.utils.Constants.BASEURL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit {
       return Retrofit.Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun providesApiServices(retrofit: Retrofit):StudentBeansResponse = retrofit.create(StudentBeansResponse::class.java)



}