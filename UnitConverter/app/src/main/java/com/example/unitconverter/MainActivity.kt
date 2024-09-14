package com.example.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unitconverter.ui.theme.UnitConverterTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    UnitConverter()
                }
            }
        }
    }
}

@Composable
fun UnitConverter() {
    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var iDropdown by remember { mutableStateOf(false) }
    var oDropdown by remember { mutableStateOf(false) }
    val unitFraction = remember { mutableStateOf(1.00) }
    val oUnitFraction = remember { mutableStateOf(1.00) }
    var inputUnit by remember { mutableStateOf("Meter") }
    var outputUnit by remember { mutableStateOf("Meter") }

    val customTextStyle = TextStyle(
        color = Color.Blue,
        fontSize = 16.sp,
        fontFamily = FontFamily.Default
    )

    fun convertUnit() {
        // ?: -> elvis operator
        // nullable expression ?: fallback value
        // in js we use ?? or ||
        val doubleInputValue = inputValue.toDoubleOrNull() ?: 0.0
        val result = (doubleInputValue * unitFraction.value * 100.0 / oUnitFraction.value ).roundToInt() / 100.0
        outputValue = result.toString()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Unit Converter", style = MaterialTheme.typography.headlineLarge)
        Text(text = "find your unit!", style = customTextStyle)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            label = { Text("Input value") },
            value = inputValue,
            onValueChange = {
                inputValue = it
                convertUnit()
            }
        )
        Spacer(modifier = Modifier.height(16.dp))

        Row {
            Box {
                Button(onClick = { iDropdown = true }) {
                    Text(inputUnit)
                    Icon(Icons.Default.ArrowDropDown, "Arrow Dropdown")
                }
                DropdownMenu(expanded = iDropdown, onDismissRequest = { iDropdown = false }) {
                    DropdownMenuItem(
                        text = { Text(text = "Centimeter") },
                        onClick = {
                            inputUnit = "Centimeter"
                            iDropdown = false
                            unitFraction.value = 0.01
                            convertUnit()
                        }
                    )
                    DropdownMenuItem(text = { Text(text = "Meter") }, onClick = {
                        inputUnit = "Meter"
                        iDropdown = false
                        unitFraction.value = 1.00
                        convertUnit()
                    })
                    DropdownMenuItem(text = { Text(text = "Feet") }, onClick = {
                        inputUnit = "Feet"
                        iDropdown = false
                        unitFraction.value = 0.3048
                        convertUnit()
                    })
                    DropdownMenuItem(text = { Text(text = "Millimeter") }, onClick = {
                        inputUnit = "Millimeter"
                        iDropdown = false
                        unitFraction.value = 0.001
                        convertUnit()
                    })
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            Box {
                Button(onClick = { oDropdown = true }) {
                    Text(outputUnit)
                    Icon(Icons.Default.ArrowDropDown, "Arrow Dropdown")
                }
                DropdownMenu(expanded = oDropdown, onDismissRequest = { oDropdown = false }) {
                    DropdownMenuItem(text = { Text(text = "Centimeter") }, onClick = {
                        outputUnit = "Centimeter"
                        oUnitFraction.value = 0.01
                        oDropdown = false
                        convertUnit()
                    })
                    DropdownMenuItem(text = { Text(text = "Meter") }, onClick = {
                        outputUnit = "Meter"
                        oUnitFraction.value = 1.00
                        oDropdown = false
                        convertUnit()
                    })
                    DropdownMenuItem(text = { Text(text = "Feet") }, onClick = {
                        outputUnit = "Feet"
                        oUnitFraction.value = 0.3048
                        oDropdown = false
                        convertUnit()
                    })
                    DropdownMenuItem(text = { Text(text = "Millimeter") }, onClick = {
                        outputUnit = "Millimeter"
                        oUnitFraction.value = 0.001
                        oDropdown = false
                        convertUnit()
                    })
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Result")
        Text(text = "$outputValue $outputUnit", style = MaterialTheme.typography.headlineMedium)
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() { // always add prefix "Preview"
    UnitConverter()
}