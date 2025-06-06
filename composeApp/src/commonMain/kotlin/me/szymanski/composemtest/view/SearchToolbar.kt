package me.szymanski.composemtest.view


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import composemtest.composeapp.generated.resources.Res
import composemtest.composeapp.generated.resources.ic_search_32
import me.szymanski.composemtest.style.Colors
import me.szymanski.composemtest.style.Dimens
import me.szymanski.composemtest.style.Font
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchListToolbar(
    searchValue: () -> String,
    searchIconDescription: @Composable () -> String,
    onValueChange: (String) -> Unit,
) {
    TopAppBar(
        title = {
            OutlinedTextField(
                value = searchValue(),
                singleLine = true,
                onValueChange = {
                    onValueChange(it)
                },
                textStyle = TextStyle(
                    fontSize = Dimens.barTextSize,
                    fontFamily = Font.lato(),
                    color = Colors.barText(),
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                ),
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors().copy(
                    focusedIndicatorColor = Colors.barText(),
                    unfocusedIndicatorColor = Colors.barTextAlpha(),
                )
            )
        },
        navigationIcon = {
            Image(
                modifier = Modifier.padding(4.dp),
                painter = painterResource(Res.drawable.ic_search_32),
                contentDescription = searchIconDescription(),
                colorFilter = ColorFilter.tint(Colors.barText()),
            )
        },
        colors = topAppBarColors(
            containerColor = Colors.colorPrimary(),
        ),
    )
}
