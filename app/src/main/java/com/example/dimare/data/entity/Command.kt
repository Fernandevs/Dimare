package com.example.dimare.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "commands")
class Command(
    @PrimaryKey(autoGenerate = true)
    val commandId: Long,
    val pizzaId: Long,
    val subtotal: Double,
    val total: Double,
    val datetime: String
)
