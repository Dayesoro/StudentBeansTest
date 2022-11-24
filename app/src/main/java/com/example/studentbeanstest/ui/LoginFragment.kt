package com.example.studentbeanstest.ui

import android.os.Bundle
import android.os.PatternMatcher
import android.text.TextUtils
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.studentbeanstest.R
import com.example.studentbeanstest.databinding.FragmentLoginBinding
import java.util.regex.Matcher


class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        setupValidation()
        return binding.root
    }

    private fun setupValidation() {
        binding.logInButton.setOnClickListener {
        if (validation()){
            findNavController().navigate(R.id.action_loginFragment_to_listFragment)
        }


        }
    }

    /** Handles EditTextView validation
     * Check for empty field
     * and valid email
     */
    private fun validation():Boolean{
        val email = binding.emailEditText.text.toString()
        val password = binding.passwordEditText.text.toString()

        return when{
            email.isEmpty()->{
                binding.emailEditText.error = "Email cannot be empty"
                 false
            }
            !Patterns.EMAIL_ADDRESS.matcher(email).matches()->{
                binding.emailEditText.error = "invalid email pattern"
                binding.email.hint ="abc@mail.com"
                false
            }
            password.isEmpty()->{
                binding.passwordEditText.error = "Password cannot be empty"
                false
            }
            else-> {
                true
            }
        }
    }


}