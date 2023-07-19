package com.alexmumo.presentation.search.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.alexmumo.domain.model.Article
import com.alexmumo.presentation.R

@Composable
fun SearchCard(
    modifier: Modifier = Modifier,
    article: Article
) {
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .crossfade(true)
                    .data(article.urlToImage)
                    .placeholder(R.drawable.ic_home),
                contentScale = ContentScale.Crop,
                contentDescription = "search",
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
            )
            Column{
                Text(
                    text = article.title!!,
                    fontWeight = FontWeight.Thin,
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Preview
@Composable
fun SearchItemPreview() {
}
