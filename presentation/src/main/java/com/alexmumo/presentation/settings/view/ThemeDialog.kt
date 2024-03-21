/*
 * Copyright 2023 News-App
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alexmumo.presentation.settings.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
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
        modifier = Modifier.testTag("alert_dialog_tag"),
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
                modifier = Modifier.clickable { onDismiss() },
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    )
}

@Preview
@Composable
fun ThemeDialogPreview() {
    // ThemeDialog()
}
