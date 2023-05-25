package com.example.dimare.data.entity

import androidx.room.Embedded
import androidx.room.Relation

class CommandWithPizzas(
    @Embedded val command: Command,
    @Relation(
        parentColumn = "commandId",
        entityColumn = "pizzaId"
    )
    val pizzas: List<Pizza>
)
