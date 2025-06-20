package me.szymanski.composemtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(
                logger = AndroidLogger(),
                mapView = { MapView() },
                closeApp = { finish() }
            )
        }
    }
}

@Composable
private fun MapView() {
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(LatLng(52.2423, 20.8962), 8f)
    }
    GoogleMap(
        cameraPositionState = cameraPositionState
    )
}

@Preview
@Composable
fun AppAndroidPreview() {
    App(
        logger = AndroidLogger(),
        mapView = {},
        closeApp = {}
    )
}
