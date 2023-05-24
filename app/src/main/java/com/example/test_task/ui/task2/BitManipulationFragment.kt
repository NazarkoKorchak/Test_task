package com.example.test_task.ui.task2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.test_task.databinding.FragmentBitManipulationBinding

class BitManipulationFragment : Fragment() {

    private var _binding: FragmentBitManipulationBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<BitManipulationViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBitManipulationBinding.inflate(inflater, container, false)

        viewModel.result.observe(viewLifecycleOwner) {
            binding.tvResult.text = it
        }

        binding.btnCalculate.setOnClickListener {
            viewModel.calculateBitDifference(
                binding.etFirstValue.text.toString().toIntOrNull(),
                binding.etSecondValue.text.toString().toIntOrNull()
            )
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}