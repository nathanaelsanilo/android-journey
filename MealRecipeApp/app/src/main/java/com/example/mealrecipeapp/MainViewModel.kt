package com.example.mealrecipeapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel() : ViewModel() {

    data class ViewModelState(
        val loading: Boolean = true,
        val error: String? = null,
        val list: List<Category> = emptyList()
    )

    private val _viewModelState = mutableStateOf(ViewModelState())
    val viewModelState : State<ViewModelState> = _viewModelState

    init {
        fetchCategories()
    }

    fun fetchCategories() {
        viewModelScope.launch {
            try {
                val response = recipeService.getCategories()
                _viewModelState.value = _viewModelState.value.copy(
                    loading = false,
                    error = null,
                    list = response.categories
                )
            } catch (e : Exception) {
                _viewModelState.value = _viewModelState.value.copy(
                    loading = false,
                    error = "Error happened: ${e.message}"
                )
            }


        }
    }
}