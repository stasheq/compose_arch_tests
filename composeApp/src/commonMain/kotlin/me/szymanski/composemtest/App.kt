package me.szymanski.composemtest

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import me.szymanski.composemtest.style.Colors
import me.szymanski.composemtest.view.list.ListScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    Surface(
        color = Colors.background(),
        modifier = Modifier.fillMaxSize()
    ) {
        var searchText by remember { mutableStateOf("") }
        ListScreen(
            items = { emptyList() },
            listVisible = { true },
            centerLoading = { false },
            pullLoading = { false },
            hasNextPage = { false },
            error = { null },
            errorIconDescription = { "" },
            searchIconDescription = { "" },
            searchValue = { searchText },
            onValueChange = { searchText = it },
            onPullToRefresh = {},
            onLoadNextPage = {},
        )
    }
}
