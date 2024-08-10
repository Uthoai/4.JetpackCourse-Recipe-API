package com.free.master.chef.recipe.meal.cook.book.view

sealed class Screen(val route: String) {
    object RecipeScreen: Screen("recipescreen")
    object CategoryDetailScreen: Screen("categorydetailscreen")
}