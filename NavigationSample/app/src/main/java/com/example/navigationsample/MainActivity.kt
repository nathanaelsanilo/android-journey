package com.example.navigationsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationsample.ui.theme.NavigationSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    // https://developer.android.com/guide/navigation/navcontroller
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "first_screen") {
        composable(route = "first_screen") {
            FirstScreen { name, age ->
                navController.navigate("second_screen/$name/$age")
            }
        }
        composable(route = "second_screen/{name}/{age}") {
            val name = it.arguments?.getString("name") ?: "No name"
            val age = it.arguments?.getString("age") ?: ""
            SecondScreen(
                name = name,
                age = age.toInt(),
                navigateToFirstScreen = {
                    navController.navigate("first_screen")
                }, navigateToThirdScreen = {
                    navController.navigate("third_screen")
                })
        }

        composable(route = "third_screen") {
            ThirdScreen {
                navController.navigate("first_screen")
            }
        }
    }

}