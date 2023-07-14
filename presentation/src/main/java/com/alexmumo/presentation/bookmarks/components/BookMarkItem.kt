package com.alexmumo.presentation.bookmarks.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.alexmumo.database.entity.BookMarkEntity

@Composable
fun BookMarkItem(
    bookMarkEntity: BookMarkEntity
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(5.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            Card(
                modifier = Modifier
                    .height(80.dp)
                    .width(80.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(bookMarkEntity.urlToImage)
                        .crossfade(true)
                        .build(),
                    modifier = Modifier.size(80.dp),
                    contentDescription = "image",
                    contentScale = ContentScale.FillBounds
                )
            }
            Spacer(modifier = Modifier.width(5.dp))
            Column {
                Text(
                    text = bookMarkEntity.description!!,
                    maxLines = 2,
                    fontSize = 16.sp,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = bookMarkEntity.author!!,
                    maxLines = 1,
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Preview
@Composable
fun BookMarkItemPreview() {
    // BookMarkItem()
}
