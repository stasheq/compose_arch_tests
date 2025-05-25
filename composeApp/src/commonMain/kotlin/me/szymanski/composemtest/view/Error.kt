package me.szymanski.composemtest.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import composemtest.composeapp.generated.resources.Res
import composemtest.composeapp.generated.resources.ic_warning_64
import me.szymanski.composemtest.style.Colors
import me.szymanski.composemtest.style.Dimens
import me.szymanski.composemtest.style.Font
import org.jetbrains.compose.resources.painterResource

@Composable
fun Error(
    error: () -> String?,
    errorIconDescription: () -> String
) = error()?.let {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Dimens.layoutPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(Res.drawable.ic_warning_64),
            contentDescription = errorIconDescription(),
            colorFilter = ColorFilter.tint(Colors.textSecondary()),
        )
        Text(
            modifier = Modifier.padding(top = Dimens.layoutPadding),
            text = it,
            fontSize = Dimens.centerIconTextSize,
            fontFamily = Font.lato(),
            color = Colors.textSecondary()
        )
    }
} ?: Unit
