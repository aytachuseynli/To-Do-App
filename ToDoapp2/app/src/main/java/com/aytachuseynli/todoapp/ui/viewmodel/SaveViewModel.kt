package com.aytachuseynli.todoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.aytachuseynli.todoapp.data.repo.TaskRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SaveViewModel:ViewModel() {
    var prepo =  TaskRepository()

    fun save(name:String){
        CoroutineScope(Dispatchers.Main).launch {
            prepo.save(name)
        }
    }
}