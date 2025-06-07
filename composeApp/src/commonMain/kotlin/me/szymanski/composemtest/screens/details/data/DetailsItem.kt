package me.szymanski.composemtest.screens.details.data

import org.jetbrains.compose.resources.StringResource

data class DetailsItem(
    val id: String,
    val text: StringResource,
    val description: String,
)
