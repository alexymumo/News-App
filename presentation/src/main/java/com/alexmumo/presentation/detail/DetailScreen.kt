package com.alexmumo.presentation.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.alexmumo.database.entity.BookMarkEntity
import com.alexmumo.domain.model.Article
import com.alexmumo.presentation.bookmarks.BookMarkViewModel
import com.alexmumo.repository.mappers.toSourceEntity
import org.koin.androidx.compose.getViewModel

@Composable
fun DetailScreen(
    navController: NavController,
    viewModel: BookMarkViewModel = getViewModel(),
    article: Article
) {
    Scaffold{ paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .testTag("detail_screen")
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(article.urlToImage)
                    .crossfade(true)
                    .build(),
                contentDescription = "image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(5.dp))
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(onClick = {
                    viewModel.saveBookMark(
                        BookMarkEntity(
                            author = article.author,
                            content = article.content,
                            description = article.description,
                            publishedAt = article.publishedAt,
                            sourceEntity = article.source.toSourceEntity(),
                            title = article.title,
                            url = article.url,
                            urlToImage = article.urlToImage
                        )
                    )
                }) {
                    Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = "icon")
                }
            }
            Text(
                text = article.content!!,
                fontSize = 18.sp,
                modifier = Modifier.fillMaxWidth(),
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
fun DetailScreenPreview() {
    //DetailScreen()
}
