package me.szymanski.composemtest.view.utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun Modifier.rippleClickable(
    onClick: () -> Unit
) = clickable(
    indication = ripple(),
    interactionSource = remember { MutableInteractionSource() },
    onClick = onClick
)
