package me.szymanski.composemtest.navigation

import me.szymanski.composemtest.core.utils.mutableEventFlow

class Navigator {
    val screenChange = mutableEventFlow<NavigationScreen>()
    val onBackClick = mutableEventFlow<Unit>()

    fun onBackClick() = onBackClick.tryEmit(Unit)

    fun openScreen(screen: NavigationScreen) {
        screenChange.tryEmit(screen)
    }
}
