/*
 * Copyright 2023 News-App
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alexmumo.presentation.detail

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.alexmumo.common.convertStringToDate
import com.alexmumo.database.entity.BookMarkEntity
import com.alexmumo.domain.model.Article
import com.alexmumo.presentation.R
import com.alexmumo.presentation.bookmarks.BookMarkViewModel
import com.alexmumo.repository.mappers.toSourceEntity
import org.koin.androidx.compose.getViewModel

@Composable
fun DetailScreen(
    navController: NavController,
    viewModel: BookMarkViewModel = getViewModel(),
    article: Article
) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("detail_tag"),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow),
                        contentDescription = "arrow",
                        modifier = Modifier.size(40.dp)
                    )
                }
                CustomLikeButton(
                    bookmarked = viewModel.checkBookMarked(id = article.url).observeAsState().value != null,
                    onPress = { bookmarked ->
                        if (bookmarked) {
                            Toast.makeText(context, "Liked", Toast.LENGTH_LONG).show()
                        } else {
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
                        }
                    }
                )
            }
        }
    ) { paddingValues ->
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
                    .height(230.dp),
                contentScale = ContentScale.Crop
            )
            Card(
                modifier = Modifier.fillMaxSize().padding(end = 5.dp, start = 5.dp),
                shape = RoundedCornerShape(topStart = 18.dp, topEnd = 18.dp)
            ) {
                Text(
                    text = article.content ?: "Unknown",
                    fontSize = 18.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 2.dp),
                    color = Color.White,
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Source",
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = article.source.name,
                        maxLines = 1,
                        fontSize = 16.sp,
                        color = Color.Green
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "Author",
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    article.author?.let {
                        Text(
                            text = it,
                            maxLines = 1,
                            fontSize = 16.sp,
                            color = Color.Green
                        )
                    }
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    maxLines = 1,
                    fontSize = 16.sp,
                    color = Color.Green,
                    text = convertStringToDate(article.publishedAt ?: "UnKnown")
                )
            }
        }
    }
}

@Composable
fun CustomLikeButton(
    onPress: (checkBookMark: Boolean) -> Unit = {},
    bookmarked: Boolean
) {
    IconButton(onClick = {
        onPress(bookmarked)
    }) {
        Icon(
            imageVector = Icons.Filled.FavoriteBorder, contentDescription = null,
            modifier = Modifier
                .height(30.dp)
                .width(30.dp),
            tint = if (bookmarked) {
                Color.Magenta
            } else {
                Color.Green
            }
        )
    }
}

@Composable
fun BackButton(
    onClick: () -> Unit = {}
) {
    Button(
        shape = CircleShape,
        onClick = {
            onClick()
        },
        modifier = Modifier
            .height(30.dp)
            .width(30.dp)
    ) {
        IconButton(onClick = {
            onClick()
        }) {
            Icon(Icons.Filled.ArrowBack, contentDescription = null)
        }
    }
}

@Preview
@Composable
fun DetailScreenPreview() {
    // DetailScreen()
}

@Preview
@Composable
fun LikePreview() {
    // BackButton()
}
