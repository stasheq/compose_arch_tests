package me.szymanski.composemtest.view.list.data

sealed class ListItem() {

    data class TitleDescriptionClickableItem(
        val id: String,
        val text: String?,
        val description: String?,
        var onClick: (() -> Unit)? = null,
    ) : ListItem()
}
