package com.example.mealrecipeapp

sealed class Screen(val route: String) {
    object MealRecipeScreen : Screen(route = "recipe_screen")
    object DetailScreen : Screen(route = "detail_screen")
}