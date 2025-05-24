package me.szymanski.composemtest.style

import androidx.annotation.ColorInt
import androidx.annotation.ColorLong
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

data class ColorSet(@ColorLong val bright: Long, @ColorLong val dark: Long)

fun color(@ColorLong bright: Long, @ColorLong dark: Long): (@Composable () -> Color) = { ColorSet(bright, dark).asColor() }

fun color(@ColorInt bright: Int, @ColorInt dark: Int): (@Composable () -> Color) = color(pack(bright), pack(dark))

fun color(@ColorLong color: Long): (@Composable () -> Color) = color(color, color)

fun color(@ColorInt color: Int): (@Composable () -> Color) = color(color, color)

@Composable
fun ColorSet.asColor() = Color(if (isSystemInDarkTheme()) dark else bright)

@ColorLong
fun pack(@ColorInt color: Int): Long {
    return (color.toLong() and 0xffffffffL) shl 32
}
