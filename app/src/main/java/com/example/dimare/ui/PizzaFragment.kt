package com.example.dimare.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore

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

        binding.pizzaCounter.text = "${ viewModel.pizzasCounter }"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}