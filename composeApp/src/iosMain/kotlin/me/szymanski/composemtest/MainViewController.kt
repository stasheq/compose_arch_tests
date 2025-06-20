package me.szymanski.composemtest

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.UIKitViewController
import androidx.compose.ui.window.ComposeUIViewController
import me.szymanski.composemtest.core.log.Logger
import platform.UIKit.UIViewController

fun MainViewController(
    logger: Logger,
    mapView: () -> UIViewController,
) = ComposeUIViewController {
    App(
        logger = logger,
        mapView = { MapView(mapView) },
        closeApp = {}
    )
}

@Composable
fun MapView(
    mapView: () -> UIViewController,
) = UIKitViewController(
    modifier = Modifier.fillMaxSize(),
    factory = mapView
)
