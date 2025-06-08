package me.szymanski.composemtest.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun Navigation(
    closeApp: () -> Unit
) {
    val viewModel = koinViewModel<NavigationViewModel>()
    val navController = rememberNavController()
    NavigatorEventsLaunchedEffect(viewModel, navController, closeApp)

    NavHost(
        navController = navController,
        startDestination = viewModel.initialScreen,
        builder = { screensMap() }
    )
}

@Composable
private fun NavigatorEventsLaunchedEffect(
    viewModel: NavigationViewModel,
    navController: NavHostController,
    closeApp: () -> Unit,
) = LaunchedEffect(Unit) {
    launch {
        viewModel.screenChange.collect {
            navController.navigate(it)
        }
    }
    launch {
        viewModel.onBackClick.collect {
            if (!navController.popBackStack()) {
                closeApp()
            }
        }
    }
}
