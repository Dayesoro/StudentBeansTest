package com.example.studentbeanstest.data.network.Response

class StudentBeansResponseList :ArrayList<StudentBeansResponseData>()
/**Network Response Model**/
data class StudentBeansResponseData(
    val thumbnailUrl: String,
    val title: String
)
