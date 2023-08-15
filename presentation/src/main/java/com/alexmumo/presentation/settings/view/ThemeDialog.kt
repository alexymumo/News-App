package com.alexmumo.presentation.settings.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alexmumo.presentation.R
import com.alexmumo.presentation.common.theme.Theme

@Composable
fun ThemeDialog(
    onDismiss: () -> Unit,
    onSelected: (Int) -> Unit
) {
    AlertDialog(
        onDismissRequest = {
            onDismiss()
        },
        title = {
            Text(
                text = "Theme"
            )
        },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                ThemeItem("Dark Theme", Theme.DARK_THEME.value, R.drawable.ic_theme, onSelected = onSelected)
                ThemeItem("Light Theme", Theme.LIGHT_THEME.value, R.drawable.ic_light, onSelected = onSelected)
                ThemeItem("Use System Settings", Theme.SYSTEM_THEME.value, R.drawable.ic_settings, onSelected = onSelected)
            }
        },
        confirmButton = {
            Text(
                text = "OK",
                modifier = Modifier.clickable { onDismiss() }
            )
        }
    )
}


@Preview
@Composable
fun ThemeDialogPreview() {
    //ThemeDialog()
}