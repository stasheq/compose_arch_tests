package me.szymanski.composemtest.navigation

import kotlinx.serialization.Serializable

sealed interface NavigationScreen {

    @Serializable
    object List : NavigationScreen

    @Serializable
    data class Details(val owner: String, val name: String) : NavigationScreen
}
