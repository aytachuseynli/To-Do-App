package com.aytachuseynli.todoapp.data.repo

import com.aytachuseynli.todoapp.data.datasource.TaskDatasource

class TaskRepository {
    var tds = TaskDatasource()

    suspend fun save(name:String) = tds.save(name)
}