package me.szymanski.composemtest.screens.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import me.szymanski.composemtest.screens.details.data.DetailsItem
import me.szymanski.composemtest.view.ListItem
import me.szymanski.composemtest.view.data.TitleDescriptionClickableItem
import org.jetbrains.compose.resources.stringResource

@Composable
fun DetailsItemsList(
    isListVisible: () -> Boolean,
    items: () -> List<DetailsItem>,
) = if (isListVisible()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        items().forEach { ListItem(TitleDescriptionClickableItem(it.id, stringResource(it.text), it.description)) }
        Spacer(Modifier.windowInsetsBottomHeight(WindowInsets.systemBars))
    }
} else Unit
