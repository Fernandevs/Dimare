package com.example.dimare.data.entities

import java.time.LocalDateTime

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "commands")
class Command(
    @PrimaryKey(autoGenerate = true)
    val commandId: Long = 0,
    val pizzas: String,
    val subtotal: Double,
    val total: Double,
    val datetime: LocalDateTime = LocalDateTime.now()
)
