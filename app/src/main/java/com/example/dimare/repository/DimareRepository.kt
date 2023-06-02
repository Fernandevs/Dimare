package com.example.dimare.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.dimare.data.dao.CommandDao
import com.example.dimare.data.entities.Command

class DimareRepository (private val commandDao: CommandDao) {
    val commands: LiveData<List<Command>> = commandDao.findAll()
    suspend fun insertCommand(command: Command) = commandDao.insert(command = command)
    suspend fun updateCommand(command: Command) = commandDao.update(command = command)
    suspend fun removeCommand(command: Command) = commandDao.remove(command = command)
}
