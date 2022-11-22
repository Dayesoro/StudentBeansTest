package com.example.studentbeanstest.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.studentbeanstest.R
import com.example.studentbeanstest.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

lateinit var binding:FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        setupValidation()
        return binding.root
    }

    private fun setupValidation() {
        binding.logInButton.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_listFragment)
        }
    }


}