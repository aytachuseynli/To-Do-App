package com.aytachuseynli.todoapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.aytachuseynli.todoapp.R
import com.aytachuseynli.todoapp.databinding.ActivityMainBinding
import com.aytachuseynli.todoapp.databinding.FragmentMainBinding
import com.aytachuseynli.todoapp.databinding.FragmentSaveBinding
import com.aytachuseynli.todoapp.ui.viewmodel.SaveViewModel

class SaveFragment : Fragment() {
    private lateinit var binding: FragmentSaveBinding
    private lateinit var viewModel: SaveViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {// Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_save, container, false)
        binding.saveFragment = this
        binding.toolbarSaveTitle= "Create Task"
        return binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:SaveViewModel by viewModels()
        viewModel = tempViewModel
    }


    fun save(name:String){
       viewModel.save(name)
    }
}