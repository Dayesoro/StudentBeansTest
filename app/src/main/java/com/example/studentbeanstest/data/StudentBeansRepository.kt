package com.example.studentbeanstest.data


import com.example.studentbeanstest.data.network.Response.StudentBeansResponseList
import com.example.studentbeanstest.data.network.ApiServices
import com.example.studentbeanstest.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class StudentBeansRepository @Inject constructor(private val apiServices: ApiServices) {

    fun fetchData() : Flow<DataState<StudentBeansResponseList>> {
       return flow {
           emit(DataState.Loading())
           try {
               val response = apiServices.fetchData()
               emit(DataState.Success(response))
           }catch (e:HttpException){
               emit(DataState.Error(e.message?:"UNKNOWN ERROR"))
           }
       }
    }
}