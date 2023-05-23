package com.example.test_task.ui.task2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.test_task.databinding.FragmentBitManipulationBinding

class BitManipulationFragment : Fragment() {

    private var _binding: FragmentBitManipulationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val bitManipulationViewModel =
            ViewModelProvider(this)[BitManipulationViewModel::class.java]

        _binding = FragmentBitManipulationBinding.inflate(inflater, container, false)

        bitManipulationViewModel.result.observe(viewLifecycleOwner) {
            binding.tvResult.text = it
        }

        binding.btnCalculate.setOnClickListener {
            bitManipulationViewModel.calculateBitDifference(
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