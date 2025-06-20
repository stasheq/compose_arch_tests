package me.szymanski.composemtest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import me.szymanski.composemtest.screens.details.DetailsScreen
import me.szymanski.composemtest.screens.list.ListScreen

fun NavGraphBuilder.screensMap(
    mapView: @Composable () -> Unit,
) {
    composable<NavigationScreen.List> {
        ListScreen()
    }
    composable<NavigationScreen.Details> {
        val args = it.toRoute<NavigationScreen.Details>()
        DetailsScreen(args, mapView)
    }
}
