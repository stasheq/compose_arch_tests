package me.szymanski.composemtest.screens.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import composemtest.composeapp.generated.resources.Res
import composemtest.composeapp.generated.resources.icon_back
import composemtest.composeapp.generated.resources.icon_error
import me.szymanski.composemtest.navigation.NavigationScreen
import me.szymanski.composemtest.style.Colors
import me.szymanski.composemtest.view.Error
import me.szymanski.composemtest.view.Loading
import me.szymanski.composemtest.view.TitleToolbar
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun DetailsScreen(
    args: NavigationScreen.Details,
    mapView: @Composable () -> Unit,
) {
    val viewModel = koinViewModel<DetailsScreenViewModel>()
    viewModel.setArgs(args)

    Column {
        val title by viewModel.title.collectAsState()
        TitleToolbar({ title }, { stringResource(Res.string.icon_back) }, viewModel::onBackClick)
        Box(modifier = Modifier.fillMaxWidth().height(250.dp)) {
            mapView()
        }
        Box(
            modifier = Modifier.background(Colors.background())
        ) {
            val error by viewModel.error.collectAsState()
            Error({ error?.let { stringResource(it) } }, { stringResource(Res.string.icon_error) })

            val loading by viewModel.isLoading.collectAsState()
            Loading { loading }

            val items by viewModel.items.collectAsState()
            val listVisible by viewModel.listVisible.collectAsState()
            DetailsItemsList({ listVisible }, { items })
        }
    }
}
