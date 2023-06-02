package com.example.dimare.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.example.dimare.R
import com.example.dimare.data.entities.Pizza
import com.example.dimare.viewmodel.DimareViewModel

class PizzaItemAdapter(
    private val pizzas: List<Pizza>,
    private val viewModel: DimareViewModel
) : RecyclerView.Adapter<PizzaItemAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pizzaType: TextView = itemView.findViewById(R.id.pizzaType)
        val pizzaDescription: TextView = itemView.findViewById(R.id.pizzaDescription)
        val pizzaPrice: TextView = itemView.findViewById(R.id.pizzaPrice)
        val addPizza: ImageButton = itemView.findViewById(R.id.addPizza)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pizza_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = pizzas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pizza = pizzas[position]

        holder.pizzaType.text = pizza.type.toString()
        holder.pizzaDescription.text = pizza.description
        holder.pizzaPrice.text = pizza.price.toString()
        holder.addPizza.setOnClickListener {
            viewModel.addPizza(pizza = pizza)
        }
    }
}
