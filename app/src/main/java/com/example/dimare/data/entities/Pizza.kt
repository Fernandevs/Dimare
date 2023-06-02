package com.example.dimare.data.entities

import com.example.dimare.data.enums.PizzaType

data class Pizza(
    val type: PizzaType,
    val description: String,
    val price: Double,
    var quantity: Int
) {
    override fun toString(): String = "Pizza(type=$type, description='$description', price=$price)"
}
