package com.aytachuseynli.todoapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.aytachuseynli.todoapp.R
import com.aytachuseynli.todoapp.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,  savedInstanceState: Bundle?): View? {
       binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detail, container, false)
        binding.detailFragment = this
        binding.toolbarDetailTitle = "Task Detail"

        val bundle:DetailFragmentArgs by navArgs()
        val resultTask = bundle.task

        binding.task = resultTask

        return binding.root
    }

    fun update(id:Int, name:String,){
        Log.e("Task Update","$id - $name")
    }

}