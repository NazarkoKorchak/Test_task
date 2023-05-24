package com.example.test_task.ui.task2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BitManipulationViewModel : ViewModel() {

    private val _result = MutableLiveData<String>()
    val result: LiveData<String> = _result

    fun calculateBitDifference(x: Int?, y: Int?) {
        if (x == null || y == null) {
            _result.value = "Please fill both values"
            return
        }

        _result.value = countSetBits(x xor y).toString()
    }

    /**
     * logic behind calculation of set bits (1) for provided int number.
     */
    private fun countSetBits(number: Int): Int =
        when (number) {
            0 -> 0
            else -> (number and 1) + countSetBits(number shr 1)
        }
}