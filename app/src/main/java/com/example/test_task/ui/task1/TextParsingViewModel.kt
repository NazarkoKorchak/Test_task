package com.example.test_task.ui.task1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TextParsingViewModel : ViewModel() {

    private val _text = MutableLiveData<String>()
    val text: LiveData<String> = _text

    private val dictionary: Set<String> = setOf("apple", "pie", "shoe", "second", "secondary")

    fun segment(input: String) {
        val segmentedString = StringBuilder()

        dictionary.forEach { word ->
            if (input.contains(word)) {
                segmentedString.append("$word ")
            }
        }

        if (segmentedString.toString().isNotEmpty()) {
            _text.value = segmentedString.toString().trim()
        } else {
            _text.value = "Can't parse this word"
        }
    }
}