package com.example.dimare.repository

import androidx.lifecycle.LiveData

import com.example.dimare.data.dao.CommandDao
import com.example.dimare.data.dao.PizzaDao
import com.example.dimare.data.entity.Command
import com.example.dimare.data.entity.Pizza

class DimareRepository (
    private val commandDao: CommandDao,
    private val pizzaDao: PizzaDao
){
    val allPizzas: LiveData<List<Pizza>> = pizzaDao.findAll()
    val allCommands: LiveData<List<Command>> = commandDao.findAll()

    suspend fun insertPizza(pizza: Pizza) = pizzaDao.insert(pizza = pizza)
    suspend fun updatePizza(pizza: Pizza) = pizzaDao.update(pizza = pizza)
    suspend fun removePizza(pizza: Pizza) = pizzaDao.remove(pizza = pizza)
}
