package com.example.studentbeanstest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.studentbeanstest.adapter.ItemAdapter
import com.example.studentbeanstest.databinding.FragmentListBinding
import com.example.studentbeanstest.utils.DataState
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private val viewModel by viewModels<StudentBeansVM>()
    private val listAdapter = ItemAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater,container,false)
        setUpViews()
        subscribeObserver()
        return binding.root
    }

    private fun subscribeObserver() {
        lifecycleScope.launchWhenStarted {
            viewModel.dataFlow.collect{ response->
                when(response){
                    is DataState.Error ->{

                    }
                    is DataState.Loading -> {

                    }
                    is DataState.Success -> {
                      listAdapter.submitList(response.response)
                    }
                }
            }
        }
    }

    private fun setUpViews() {
        binding.listView.adapter = listAdapter
        binding.listView.layoutManager = LinearLayoutManager(context,VERTICAL,false)

        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }


}