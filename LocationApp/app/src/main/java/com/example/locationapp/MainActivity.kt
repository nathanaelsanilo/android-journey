package com.example.locationapp

import android.Manifest
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.locationapp.ui.theme.LocationAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val locationViewModel : LocationViewModel = viewModel()

            LocationAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    MyApp(locationViewModel)
                }
            }
        }
    }
}

@Composable
fun MyApp(viewModel: LocationViewModel) {
    // use current context
    val context = LocalContext.current;
    val locationUtils = LocationHelper(context)
    LocationDisplay(context = context, locationUtils = locationUtils, viewModel)
}

@Composable
fun LocationDisplay(context: Context, locationUtils: LocationHelper, viewModel: LocationViewModel) {

    val location = viewModel.location.value
    val address = location?.let {
        locationUtils.reverseGeoLocation(it)
    }

    // show popup (Activity) to ask permission
    val requestPermissionLauncher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.RequestMultiplePermissions(),
            onResult = { permissions ->
                if (permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true && permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true) {
                    // access granted
                    locationUtils.requestLocationUpdate(viewModel)
                } else {
                    // ask permission
                    val askFineLocation = ActivityCompat.shouldShowRequestPermissionRationale(
                        context as MainActivity, Manifest.permission.ACCESS_FINE_LOCATION
                    )
                    val askCoarseLocation = ActivityCompat.shouldShowRequestPermissionRationale(
                        context as MainActivity, Manifest.permission.ACCESS_COARSE_LOCATION
                    )
                    val rationaleRequired: Boolean = askFineLocation || askCoarseLocation

                    // give user permission why we need those permissions
                    if (rationaleRequired) {
                        Toast.makeText(
                            context,
                            "Location permissions is required",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        Toast.makeText(
                            context,
                            "Location permissions is required. Give location access to this location through Android settings",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            })

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        if (location != null) {
            Text("Address: $address")
            Text(text = "Location: ${location.latitude} and ${location.longitude}")
        } else {
            Text(text = "Location not available!")
        }


        Button(onClick = {
            if (locationUtils.hasGrantAccess(context)) {
                // already grant permission
                locationUtils.requestLocationUpdate(viewModel)
            } else {
                // launch request permission. Pass the permission that we need
                requestPermissionLauncher.launch(
                    arrayOf(
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    )
                )
            }
        }) {
            Text(text = "Get location")
        }
    }
}