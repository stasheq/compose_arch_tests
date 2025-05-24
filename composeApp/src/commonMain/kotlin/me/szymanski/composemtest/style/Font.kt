package me.szymanski.composemtest.style

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import composemtest.composeapp.generated.resources.Res
import composemtest.composeapp.generated.resources.lato_regular
import org.jetbrains.compose.resources.Font

object Font {
    val lato = @Composable { FontFamily(Font(Res.font.lato_regular)) }
}
