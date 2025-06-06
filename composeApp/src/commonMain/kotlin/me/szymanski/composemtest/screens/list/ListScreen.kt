package me.szymanski.composemtest.screens.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import composemtest.composeapp.generated.resources.Res
import composemtest.composeapp.generated.resources.icon_error
import composemtest.composeapp.generated.resources.icon_search
import me.szymanski.composemtest.view.Error
import me.szymanski.composemtest.view.Loading
import me.szymanski.composemtest.view.SearchListToolbar
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen() = Column {
    val viewModel = koinViewModel<ListScreenViewModel>()

    val userName by viewModel.userName.collectAsState()
    SearchListToolbar({ userName }, { stringResource(Res.string.icon_search) }, viewModel::onValueChange)

    val pullLoading by viewModel.pullLoading.collectAsState()
    PullToRefreshBox(
        isRefreshing = pullLoading,
        onRefresh = viewModel::onPullToRefresh,
        modifier = Modifier.fillMaxSize()
    ) {
        val error by viewModel.error.collectAsState()
        Error({ error?.let { stringResource(it) } }, { stringResource(Res.string.icon_error) })

        val centerLoading by viewModel.centerLoading.collectAsState()
        Loading { centerLoading }

        val itemsList by viewModel.items.collectAsState()
        val listVisible by viewModel.listVisible.collectAsState()
        val hasNextPage by viewModel.hasNextPage.collectAsState()
        ItemsList(
            isListVisible = { listVisible },
            items = { itemsList },
            hasNextPage = { hasNextPage },
            onLoadNextPage = viewModel::loadNextPage
        )
    }
}
