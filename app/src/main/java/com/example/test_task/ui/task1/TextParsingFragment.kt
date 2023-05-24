package com.example.test_task.ui.task1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.test_task.databinding.FragmentTextParsingBinding

class TextParsingFragment : Fragment() {

    private var _binding: FragmentTextParsingBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<TextParsingViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTextParsingBinding.inflate(inflater, container, false)

        viewModel.text.observe(viewLifecycleOwner) {
            binding.tvResult.text = it
        }

        binding.btnParse.setOnClickListener {
            val input = binding.etValue.text.trim().toString()
            viewModel.segment(input)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}