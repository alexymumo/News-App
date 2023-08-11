package com.alexmumo.designsystem

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MediumSpacer() {
    Spacer(modifier = Modifier.height(4.dp))
}

@Preview
@Composable
fun MediumSpacerPreview() {
    MediumSpacer()
}