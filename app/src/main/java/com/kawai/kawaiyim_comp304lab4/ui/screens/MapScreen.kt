
@file:OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)
package com.kawai.kawaiyim_comp304lab4.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*

@Composable
fun MapScreen(
    name: String,
    address: String,
    lat: Double,
    lng: Double,
    onBack: () -> Unit
) {
    val camera = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(LatLng(lat, lng), 15f)
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(name) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = null)
                    }
                }
            )
        }
    ) { pad ->
        GoogleMap(
            modifier = Modifier
                .fillMaxSize()
                .padding(pad),
            cameraPositionState = camera
        ) {
            Marker(
                state = MarkerState(LatLng(lat, lng)),
                title = name,
                snippet = address
            )
        }
    }
}
