package com.aytachuseynli.todoapp.data.datasource

import android.util.Log
import com.aytachuseynli.todoapp.data.entity.Tasks
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TaskDatasource {
    suspend fun save(name:String){
        Log.e("Task Save","$name")
    }


    suspend fun update(id:Int, name:String){
        Log.e("Task Update","$name")
    }

    suspend fun delete(id:Int){
        Log.e("Task Delete",id.toString())
    }





}