package com.example.test_task

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.test_task.ui.task1.TextParsingViewModel
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class TextParsingViewModelTest {

    private val viewModel = TextParsingViewModel()

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Test
    fun segment_isCorrect() {
        viewModel.segment("applepie")
        Assert.assertEquals("apple pie", viewModel.text.value )
    }

    @Test
    fun segment_isIncorrect() {
        viewModel.segment("test")
        Assert.assertEquals("Can't parse this word", viewModel.text.value )
    }
}