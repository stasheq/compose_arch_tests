package me.szymanski.composemtest.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import me.szymanski.composemtest.style.Colors
import me.szymanski.composemtest.style.Dimens
import me.szymanski.composemtest.style.Font
import me.szymanski.composemtest.view.data.TitleDescriptionClickableItem

@Composable
fun ListItem(item: TitleDescriptionClickableItem) = Column(
    modifier = Modifier.let {
        if (item.onClick != null)
            it.clickable(
                indication = ripple(),
                interactionSource = remember { MutableInteractionSource() },
                onClick = { item.onClick?.invoke() })
        else it
    }
) {
    Text(
        text = item.text ?: "",
        modifier = Modifier
            .padding(top = Dimens.layoutPadding)
            .padding(horizontal = Dimens.layoutPadding),
        fontSize = Dimens.titleTextSize,
        fontWeight = FontWeight.Bold,
        fontFamily = Font.lato(),
        color = Colors.text()
    )
    Text(
        text = item.description ?: "",
        modifier = Modifier
            .padding(top = Dimens.textPadding)
            .padding(horizontal = Dimens.layoutPadding),
        fontSize = Dimens.textSize,
        fontFamily = Font.lato(),
        color = Colors.text()
    )
    HorizontalDivider(
        modifier = Modifier
            .padding(top = Dimens.layoutPadding)
            .padding(horizontal = Dimens.layoutPadding),
        thickness = Dimens.dividerThickness,
        color = Colors.divider(),
    )
}
