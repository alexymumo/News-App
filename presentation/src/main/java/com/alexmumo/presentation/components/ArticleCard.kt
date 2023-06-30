package com.alexmumo.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.alexmumo.domain.model.Article

@Composable
fun NewsCard(
    onNavigate: (Article) -> Unit,
    article: Article,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(4.dp),
        onClick = {
            onNavigate(article)
        }
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(all = 4.dp)
                .testTag("news_card")
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(article.urlToImage)
                    .crossfade(true)
                    .build(),
                contentDescription = "url_image",
                modifier = modifier
                    .height(130.dp)
                    .width(130.dp).clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = modifier.width(2.dp))
            Column {
                Text(
                    text = article.title!!,
                    maxLines = 2,
                    fontWeight = FontWeight.Thin,
                    fontSize = 16.sp
                )
                Spacer(modifier = modifier.height(4.dp))
                Text(
                    text = article.source.name,
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Light,
                    maxLines = 1
                )
            }
        }
        Divider(
            modifier = Modifier.fillMaxWidth().height(2.dp)
        )
    }
}

@Preview
@Composable
fun ArticlePreview() {
    //NewsCard()
    //ArticleCard()
}