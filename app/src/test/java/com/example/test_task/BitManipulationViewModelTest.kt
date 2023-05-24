package com.example.test_task

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.test_task.ui.task2.BitManipulationViewModel
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class BitManipulationViewModelTest {

    private val viewModel = BitManipulationViewModel()

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Test
    fun calculate_isCorrect() {
        viewModel.calculateBitDifference(11, 15)
        Assert.assertEquals("1", viewModel.result.value )
    }

    @Test
    fun calculate_emptyValue() {
        viewModel.calculateBitDifference(1, null)
        Assert.assertEquals("Please fill both values", viewModel.result.value )
    }
}