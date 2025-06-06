package me.szymanski.composemtest

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import me.szymanski.composemtest.style.Colors
import me.szymanski.composemtest.screens.list.ListScreen
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication

@Composable
@Preview
fun App() = KoinApplication(application = {
    koinModules()
}) {
    Surface(
        color = Colors.background(),
        modifier = Modifier.fillMaxSize()
    ) {
        ListScreen()
    }
}
