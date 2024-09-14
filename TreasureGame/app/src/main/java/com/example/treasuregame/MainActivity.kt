package com.example.treasuregame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.treasuregame.ui.theme.TreasureGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TreasureGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TreasureGame()
                }
            }
        }
    }
}

@Composable
fun TreasureGame() {
    val direction = remember { mutableStateOf(value = "East") }
    val countTreasure = remember { mutableStateOf(value = 0) }

    // notice we are using "by" keyword to unwrap the .value
    var stormOrTreasure by remember { mutableStateOf("") }

    Column {
        Text(text = "Treasure found ${countTreasure.value}")
        Text(text = "Heading to ${direction.value}")
        Text(text = stormOrTreasure)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            if (Random.nextBoolean()) {
                countTreasure.value += 1
                stormOrTreasure = "Found a treasure!"
            } else {
                stormOrTreasure = "Storm Ahead!"
            }
            direction.value = "East"
        }) {
            Text(text = "East")
        }
        Button(onClick = {
            if (Random.nextBoolean()) {
                countTreasure.value += 1
                stormOrTreasure = "Found a treasure!"
            } else {
                stormOrTreasure = "Storm Ahead!"
            }
            direction.value = "North"
        }) {
            Text(text = "North")
        }
        Button(onClick = {
            if (Random.nextBoolean()) {
                countTreasure.value += 1
                stormOrTreasure = "Found a treasure!"
            } else {
                stormOrTreasure = "Storm Ahead!"
            }
            direction.value = "West"
        }) {
            Text(text = "West")
        }
        Button(onClick = {
            if (Random.nextBoolean()) {
                stormOrTreasure = "Found a treasure!"
                countTreasure.value += 1
            } else {
                stormOrTreasure = "Storm Ahead!"
            }
            direction.value = "South"
        }) {
            Text(text = "South")
        }
    }
}
