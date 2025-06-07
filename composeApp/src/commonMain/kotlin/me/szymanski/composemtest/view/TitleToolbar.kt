package me.szymanski.composemtest.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import composemtest.composeapp.generated.resources.Res
import composemtest.composeapp.generated.resources.ic_back_32
import me.szymanski.composemtest.style.Colors
import me.szymanski.composemtest.style.Dimens
import me.szymanski.composemtest.style.Font
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TitleToolbar(
    title: @Composable () -> String,
    onBackIconDescription: @Composable () -> String,
    onBackClick: () -> Unit,
) = TopAppBar(
    title = {
        Text(
            text = title(),
            fontSize = Dimens.barTextSize,
            fontFamily = Font.lato(),
            color = Colors.barText(),
        )
    },
    colors = topAppBarColors(
        containerColor = Colors.colorPrimary(),
    ),
    navigationIcon = {
        Image(
            modifier = Modifier.padding(4.dp).clickable(
                indication = ripple(),
                interactionSource = remember { MutableInteractionSource() },
                onClick = onBackClick,
            ),
            painter = painterResource(Res.drawable.ic_back_32),
            contentDescription = onBackIconDescription(),
            colorFilter = ColorFilter.tint(Colors.barText()),
        )
    },
)
