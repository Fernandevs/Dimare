package com.example.dimare.viewmodel

import kotlinx.coroutines.launch

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope

import com.example.dimare.data.database.DimareDatabase
import com.example.dimare.data.entities.Command
import com.example.dimare.data.entities.Pizza
import com.example.dimare.data.enums.PizzaType
import com.example.dimare.repository.DimareRepository
import com.google.gson.Gson
import java.util.function.BiConsumer
import java.util.function.Consumer

class DimareViewModel(application: Application) : AndroidViewModel(application) {
    private val database: DimareDatabase
    private val repository: DimareRepository
    val pizzas: List<Pizza>
    val commands: LiveData<List<Command>>
    var total: Double
    val pizzasCounter: MutableLiveData<Int>

    init {
        database = DimareDatabase.getDatabase(application)
        repository = DimareRepository(database.commandDao())
        pizzasCounter = MutableLiveData(0)
        total = 0.0
        commands = repository.commands
        pizzas = mutableListOf(
            Pizza(
                type = PizzaType.PEPPERONI,
                description = "Pizza de pepperoni y queso mozzarella",
                price = 99.99,
                quantity = 0
            ),
            Pizza(
                type = PizzaType.MEXICAN,
                description = "Pizza mexicana",
                price = 149.99,
                quantity = 0
            ),
            Pizza(
                type = PizzaType.CHEESE,
                description = "Pizza de cuatro quesos",
                price = 199.99,
                quantity = 0
            ),
        )
    }

    fun insertCommand(command: Command) =
        viewModelScope.launch { repository.insertCommand(command = command) }

    fun updateCommand(command: Command) =
        viewModelScope.launch { repository.updateCommand(command = command) }

    fun removeCommand(command: Command) =
        viewModelScope.launch { repository.removeCommand(command = command) }

    fun addPizza(pizza: Pizza) {
        when (pizza.type) {
            PizzaType.PEPPERONI -> pizzas[0].quantity ++
            PizzaType.MEXICAN -> pizzas[1].quantity ++
            PizzaType.CHEESE -> pizzas[2].quantity ++
        }

        Log.d("Pepperoni", pizzas[0].quantity.toString())
        Log.d("Mexican", pizzas[1].quantity.toString())
        Log.d("Cheese", pizzas[2].quantity.toString())

        pizzasCounter.value = pizzasCounter.value?.plus(1)
        total += pizza.price

        Log.d("Total", total.toString())
    }

    fun deleteAllPizzas() = pizzas.forEach { pizza -> pizza.quantity = 0}

    fun toJSON(): String = Gson().toJson(pizzas)
}
