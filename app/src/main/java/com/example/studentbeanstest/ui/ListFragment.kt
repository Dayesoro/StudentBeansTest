package com.example.studentbeanstest.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.studentbeanstest.R
import com.example.studentbeanstest.databinding.FragmentListBinding
import com.example.studentbeanstest.databinding.FragmentLoginBinding


class ListFragment : Fragment() {

private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater,container,false)
        setUpViews()
        return binding.root
    }

    private fun setUpViews() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }


}