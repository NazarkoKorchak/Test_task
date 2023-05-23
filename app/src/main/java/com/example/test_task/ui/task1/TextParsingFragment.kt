package com.example.test_task.ui.task1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.test_task.databinding.FragmentTextParsingBinding

class TextParsingFragment : Fragment() {

    private var _binding: FragmentTextParsingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val textParsingViewModel =
            ViewModelProvider(this)[TextParsingViewModel::class.java]

        _binding = FragmentTextParsingBinding.inflate(inflater, container, false)

        textParsingViewModel.text.observe(viewLifecycleOwner) {
            binding.tvResult.text = it
        }

        binding.btnParse.setOnClickListener {
            val input = binding.etValue.text.toString().trim()
            textParsingViewModel.segment(input)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}