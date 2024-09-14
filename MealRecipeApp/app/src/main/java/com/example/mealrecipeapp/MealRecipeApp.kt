package com.example.mealrecipeapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun MealRecipeApp(navController: NavHostController) {
    val recipeViewModel: MainViewModel = viewModel()
    val viewState by recipeViewModel.viewModelState

    NavHost(navController = navController, startDestination = Screen.MealRecipeScreen.route) {
        composable(route = Screen.MealRecipeScreen.route) {
            MealRecipeScreen(viewState = viewState, navigateToDetail = {
                // passing data from current screen to detail screen
                // savedStateHandle -> component of the compose navigation framework
                // if you use class to send the data, you need to parse it using Parcelize
                navController.currentBackStackEntry?.savedStateHandle?.set("cat", it)
                navController.navigate(Screen.DetailScreen.route)
            })
        }

        composable(route = Screen.DetailScreen.route) {
            // get Category from previousBackStackEntry
            val category =
                navController.previousBackStackEntry?.savedStateHandle?.get<Category>("cat")
                    ?: Category("", "", "", "")
            CategoryDetailScreen(category = category)
        }
    }

}