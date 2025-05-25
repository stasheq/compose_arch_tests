package me.szymanski.composemtest.style

import androidx.annotation.ColorInt
import androidx.annotation.ColorLong
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

data class ColorSet(@ColorLong val bright: Long, @ColorLong val dark: Long)

fun color(@ColorLong bright: Long, @ColorLong dark: Long): (@Composable () -> Color) = { ColorSet(bright, dark).asComposeColor() }

fun color(@ColorLong color: Long): (@Composable () -> Color) = color(color, color)

@Composable
fun ColorSet.asComposeColor() = Color(if (isSystemInDarkTheme()) dark else bright)
