package com.example.dimare.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

import com.example.dimare.data.database.DimareDatabase
import com.example.dimare.data.entity.Command
import com.example.dimare.data.entity.Pizza
import com.example.dimare.repository.DimareRepository

class DimareViewModel(application: Application) : AndroidViewModel(application) {
    private val database: DimareDatabase
    val allPizzas: LiveData<List<Pizza>>
    val allCommands: LiveData<List<Command>>
    val repository: DimareRepository
    val pizzasCounter: Int

    init {
        database = DimareDatabase.getDatabase(application)
        repository = DimareRepository(database.commandDao(), database.pizzaDao())
        allPizzas = repository.allPizzas
        allCommands = repository.allCommands
        pizzasCounter = 0
    }
}
