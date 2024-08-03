package com.free.master.chef.recipe.meal.cook.book.view.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.free.master.chef.recipe.meal.cook.book.service.ApiClient
import com.free.master.chef.recipe.meal.cook.book.service.data.CategoryData
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _categoriesState = mutableStateOf(RecipeState())
    val categoriesState: State<RecipeState> get() = _categoriesState

    data class RecipeState(
        val loading: Boolean = true,
        val list: List<CategoryData> = emptyList(),
        val error: String? = null
    )

    init {
        fetchCategories()
    }

    private fun fetchCategories() {
        viewModelScope.launch {
            try {
                val response = ApiClient.recipeService.getCategories()
                _categoriesState.value = _categoriesState.value.copy(
                    list = response.categoryData,
                    loading = false,
                    error = null
                )
            } catch (e: Exception) {
                _categoriesState.value = _categoriesState.value.copy(
                    loading = false,
                    error = "Error fetching Category ${e.message}"
                )
            }
        }
    }

}