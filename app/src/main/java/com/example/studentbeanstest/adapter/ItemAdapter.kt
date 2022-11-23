package com.example.studentbeanstest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.studentbeanstest.data.network.Response.StudentBeansResponseData
import com.example.studentbeanstest.databinding.ListItemBinding


class ItemAdapter: ListAdapter<StudentBeansResponseData, ItemAdapter.StudentBeanVH>(studentBeanDiff) {

    inner class StudentBeanVH(val binding:ListItemBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(data: StudentBeansResponseData){
         binding.title.text = data.title
         binding.image.load(data.thumbnailUrl)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentBeanVH {
        return StudentBeanVH(ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: StudentBeanVH, position: Int) {
        val data = getItem(position)
        holder.bind(data)
    }

    private object studentBeanDiff :DiffUtil.ItemCallback<StudentBeansResponseData>(){
        override fun areItemsTheSame(
            oldItem: StudentBeansResponseData,
            newItem: StudentBeansResponseData
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: StudentBeansResponseData,
            newItem: StudentBeansResponseData
        ): Boolean {
            return oldItem.title == newItem.title
        }

    }

}