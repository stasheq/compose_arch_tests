package me.szymanski.composemtest.view.data

data class TitleDescriptionClickableItem(
    val id: String,
    val text: String?,
    val description: String?,
    var onClick: (() -> Unit)? = null,
)
