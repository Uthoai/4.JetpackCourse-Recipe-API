package com.free.master.chef.recipe.meal.cook.book.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.free.master.chef.recipe.meal.cook.book.service.data.CategoryData
import com.free.master.chef.recipe.meal.cook.book.view.detail.CategoryDetailScreen
import com.free.master.chef.recipe.meal.cook.book.view.home.HomeViewModel
import com.free.master.chef.recipe.meal.cook.book.view.home.RecipeScreen

@Composable
fun RecipeApp(navController: NavHostController) {
    val viewModel: HomeViewModel = viewModel()
    val viewState by viewModel.categoriesState

    NavHost(navController = navController, startDestination = Screen.RecipeScreen.route) {

        composable(route = Screen.RecipeScreen.route) {
            RecipeScreen(viewState = viewState, navigateToDetail = {
                navController.currentBackStackEntry?.savedStateHandle?.set("dish", it)
                navController.navigate(Screen.RecipeScreen.route)
            })
        }
        composable(route = Screen.CategoryDetailScreen.route) {
            val category =
                navController.currentBackStackEntry?.savedStateHandle?.get<CategoryData>("dish")
                    ?: CategoryData("", "", "", "")
            CategoryDetailScreen(categoryData = category)
        }

    }
}