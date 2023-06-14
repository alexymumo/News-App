package com.alexmumo.presentation.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SettingScreen(
    settingsViewModel:SettingsViewModel = viewModel()
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Button(onClick = {
            settingsViewModel.getTheme()
        }) {
            Text(text = "Change")
        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Remain")
        }
    }
}

@Preview
@Composable
fun SettingsScreenPreview() {
    SettingScreen()
}