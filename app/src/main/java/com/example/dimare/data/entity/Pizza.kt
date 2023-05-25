package com.example.dimare.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.PrimaryKey

@Entity(tableName = "pizzas")
data class Pizza(
    @PrimaryKey(autoGenerate = true)
    val pizzaId: Long,
    val pizzaType: String,
    val description: String,
    val price: Double,
)
