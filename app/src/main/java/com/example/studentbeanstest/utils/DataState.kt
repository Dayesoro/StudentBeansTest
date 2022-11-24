package com.example.studentbeanstest.utils

/** Sealed class of three network state to help handle different state of network**/
sealed class DataState<T>(data:T?=null, isLoading:Boolean=false,error:String?=null) {

    data class Success<T>(val response:T):DataState<T>(data = response)

    class Loading<T>(val loading:Boolean=true):DataState<T>(isLoading = loading)

    data class Error<T>(val errorMessage:String):DataState<T>(error = errorMessage)
}