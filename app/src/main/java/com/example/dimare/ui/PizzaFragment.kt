package com.example.dimare.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.dimare.R
import com.example.dimare.data.adapter.PizzaItemAdapter
import com.example.dimare.data.entities.Command

import com.example.dimare.databinding.FragmentPizzaBinding
import com.example.dimare.viewmodel.DimareViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class PizzaFragment : Fragment() {
    private var _binding: FragmentPizzaBinding? = null
    private val binding get() = _binding!!
    private val viewModel: DimareViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPizzaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = PizzaItemAdapter(pizzas = viewModel.pizzas, viewModel = viewModel)

        binding.recyclerView.layoutManager = GridLayoutManager(
            context,
            1,
            GridLayoutManager.VERTICAL,
            false
        )

        binding.recyclerView.adapter = adapter

        binding.fab.setOnClickListener {
            val total = viewModel.total

            viewModel.insertCommand(
                Command(
                    pizzas = viewModel.toJSON(),
                    subtotal = total - total * 0.16,
                    total = total
                )
            )

            viewModel.deleteAllPizzas()

            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        viewModel.pizzasCounter.observe(viewLifecycleOwner) { counter ->
            binding.pizzaCounter.text = counter.toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
