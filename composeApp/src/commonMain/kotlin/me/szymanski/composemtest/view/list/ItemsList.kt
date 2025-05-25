package me.szymanski.composemtest.view.list

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import me.szymanski.composemtest.view.ListItem
import me.szymanski.composemtest.view.LoadingNextPageItem
import me.szymanski.composemtest.view.data.TitleDescriptionClickableItem

@Composable
fun ItemsList(
    isListVisible: () -> Boolean,
    items: () -> List<TitleDescriptionClickableItem>,
    hasNextPage: () -> Boolean,
    onLoadNextPage: () -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        if (isListVisible()) {
            val itemsList = items()
            items(itemsList.size) {
                ListItem(itemsList[it])
            }
            if (hasNextPage()) {
                item {
                    LoadingNextPageItem(onLoadNextPage)
                }
            }
        }
    }
}
