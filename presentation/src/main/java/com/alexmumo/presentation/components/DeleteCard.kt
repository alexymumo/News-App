package com.alexmumo.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.DismissDirection
import androidx.compose.material3.DismissState
import androidx.compose.material3.Icon
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DeleteCard(
    dismissState: DismissState
) {
    val color = if (dismissState.dismissDirection == DismissDirection.StartToEnd) {
        Color.Cyan
    } else Color.Transparent
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(color)
            .testTag("delete_card_tag"),
        contentAlignment = Alignment.CenterEnd
    ) {
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = null,
            tint = Color.White
        )
    }
}


@Preview
@Composable
fun DeleteCardPreview() {
    val dismissState = rememberDismissState()
    DeleteCard(dismissState = dismissState)
    
}