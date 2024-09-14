package com.example.counterapp

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private val repository = CounterRepository()
    private val _counter = mutableStateOf(repository.getCounter().count)
    val counter : MutableState<Int> = _counter

    fun increment() {
        repository.increment()
        _counter.value = repository.getCounter().count
    }

    fun decrement() {
        repository.decrement()
        _counter.value = repository.getCounter().count
    }
}