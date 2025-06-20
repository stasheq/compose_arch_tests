package me.szymanski.composemtest

import androidx.compose.ui.window.ComposeUIViewController
import me.szymanski.composemtest.core.log.Logger

fun MainViewController(
    logger: Logger
) = ComposeUIViewController {
    App(
        logger = logger,
        closeApp = {}
    )
}
