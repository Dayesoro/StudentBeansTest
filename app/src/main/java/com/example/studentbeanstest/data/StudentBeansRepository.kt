package com.example.studentbeanstest.data


import com.example.studentbeanstest.data.network.Response.StudentBeansResponseList
import com.example.studentbeanstest.data.network.ApiServices
import com.example.studentbeanstest.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class StudentBeansRepository @Inject constructor(private val apiServices: ApiServices) {

    /**
     * fetch network data and return a flow of data state
     * Loading State
     * Data State
     * Error State
     * @return Flow<DataState<>>
     */
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