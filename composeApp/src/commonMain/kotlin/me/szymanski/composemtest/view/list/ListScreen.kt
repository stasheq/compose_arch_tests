package me.szymanski.composemtest.view.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import me.szymanski.composemtest.view.SearchListToolbar
import me.szymanski.composemtest.view.list.data.ListItem.TitleDescriptionClickableItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    items: () -> List<TitleDescriptionClickableItem>,
    listVisible: () -> Boolean,
    centerLoading: () -> Boolean,
    pullLoading: () -> Boolean,
    hasNextPage: () -> Boolean,
    error: () -> String?,
    errorIconDescription: () -> String,
    searchIconDescription: () -> String,
    searchValue: () -> String,
    onValueChange: (String) -> Unit,
    onPullToRefresh: () -> Unit,
    onLoadNextPage: () -> Unit
) = Column {
    SearchListToolbar(searchValue, searchIconDescription, onValueChange)
    PullToRefreshBox(
        isRefreshing = pullLoading(),
        onRefresh = onPullToRefresh,
        modifier = Modifier.fillMaxSize()
    ) {

    }
}
