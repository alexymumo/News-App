package com.alexmumo.presentation.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SettingScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Settings Screen")
    }
}

@Preview
@Composable
fun SettingsScreenPreview() {
    SettingScreen()
}