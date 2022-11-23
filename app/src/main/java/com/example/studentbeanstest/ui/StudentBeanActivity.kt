package com.example.studentbeanstest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.studentbeanstest.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StudentBeanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_bean)
    }
}