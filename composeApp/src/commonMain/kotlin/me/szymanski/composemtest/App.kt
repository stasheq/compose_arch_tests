package me.szymanski.composemtest

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import me.szymanski.composemtest.core.log.Logger
import me.szymanski.composemtest.navigation.Navigation
import me.szymanski.composemtest.style.Colors
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication

@Composable
@Preview
fun App(
    logger: Logger,
    mapView: @Composable () -> Unit,
    closeApp: () -> Unit,
) = KoinApplication(application = {
    koinModules(logger)
}) {
    Surface(
        color = Colors.background(),
        modifier = Modifier.fillMaxSize()
    ) {
        Navigation(closeApp, mapView)
    }
}
