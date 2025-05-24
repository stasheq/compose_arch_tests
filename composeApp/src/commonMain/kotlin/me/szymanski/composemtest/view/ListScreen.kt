package me.szymanski.composemtest.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
/* TODO
@Composable
fun ListScreen(
    items: State<List<ListItemType.ListItem>>,
    isListVisible: () -> Boolean,
    centerLoading: () -> Boolean,
    pullLoading: () -> Boolean,
    hasNextPage: () -> Boolean,
    error: () -> String?,
    errorIconDescription: String,
    searchIconDescription: () -> String,
    defaultValue: String,
    onValueChange: (String) -> Unit,
    onPullToRefresh: () -> Unit,
    onLoadNextPage: () -> Unit
) = Column {
    ListToolbar(defaultValue, onValueChange, searchIconDescription)
    PullToRefreshBox(
        isRefreshing = pullLoading.value,
        onRefresh = onPullToRefresh,
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.background))
    ) {
        Error(error, errorIconDescription)
        Loading(centerLoading)
        ItemsList(isListVisible, items, hasNextPage, onLoadNextPage)
    }
}
*/