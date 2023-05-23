package com.example.test_task.ui.task2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BitManipulationViewModel : ViewModel() {

    private val _result = MutableLiveData<String>()
    val result: LiveData<String> = _result

    fun calculateBitDifference(x: Int?, y: Int?) {
        var count = 0
        if (x != null && y != null) {
            var bitDifference = x xor y
            while (bitDifference != 0) {
                count += bitDifference and 1
                bitDifference = bitDifference shr 1
            }
            _result.value = count.toString()
        } else {
            _result.value = "Please fill 2 values"
        }
    }
}