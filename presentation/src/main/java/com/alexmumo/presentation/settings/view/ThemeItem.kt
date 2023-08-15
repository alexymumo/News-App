package com.alexmumo.presentation.settings.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alexmumo.presentation.R


@Composable
fun ThemeItem(
    name: String,
    value: Int,
    icon: Int,
    onSelected: (Int) -> Unit
) {
    Card(
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            MaterialTheme.colorScheme.onSurfaceVariant
        ),
        onClick = {
            onSelected(value)
        }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.fillMaxWidth().padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null
            )
            Text(
                text = name,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}

@Preview
@Composable
fun ThemeItemPreview() {
    //ThemeItem()
}