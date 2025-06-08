package me.szymanski.composemtest.navigation

import androidx.lifecycle.ViewModel

class NavigationViewModel(
    navigator: Navigator
) : ViewModel() {

    val initialScreen = NavigationScreen.List
    val screenChange = navigator.screenChange
    val onBackClick = navigator.onBackClick
}
