package com.alexmumo.presentation.bookmarks.components

import android.widget.Space
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.alexmumo.database.entity.BookMarkEntity

@Composable
fun BookMarkItem(
    modifier: Modifier = Modifier,
    bookMark: BookMarkEntity
) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        AsyncImage(
            modifier = modifier
                .height(130.dp)
                .width(130.dp)
                .clip(RoundedCornerShape(5.dp)),
            model = bookMark.urlToImage,
            contentDescription = "bookmark_image"
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = bookMark.description!!,
            fontSize = 16.sp
        )
    }
}

@Preview
@Composable
fun BookMarkItemPreview() {
    //BookMarkItem()
}