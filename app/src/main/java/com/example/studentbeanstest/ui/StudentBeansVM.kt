package com.example.studentbeanstest.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studentbeanstest.data.StudentBeansRepository
import com.example.studentbeanstest.data.network.Response.StudentBeansResponseList
import com.example.studentbeanstest.utils.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StudentBeansVM @Inject constructor(private val repository: StudentBeansRepository):ViewModel() {
    private var _dataFlow:MutableStateFlow<DataState<StudentBeansResponseList>> = MutableStateFlow(DataState.Loading())
    val dataFlow:StateFlow<DataState<StudentBeansResponseList>> get() = _dataFlow.asStateFlow()

    init {
        fetchData()
    }

   private fun fetchData(){
        viewModelScope.launch(IO) {
            repository.fetchData().collect{
                _dataFlow.value = it
            }
        }
    }

}