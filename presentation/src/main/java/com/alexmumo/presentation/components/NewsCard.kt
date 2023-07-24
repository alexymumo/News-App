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
        modifier = modifier
            .padding(all = 4.dp)
            .testTag("news_card_tag"),
        shape = RoundedCornerShape(4.dp),
        onClick = {
            onNavigate(article)
        }
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(all = 4.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(article.urlToImage)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                modifier = modifier
                    .height(145.dp)
                    .width(145.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = modifier.width(4.dp))
            Column {
                Text(
                    text = article.source.name,
                    maxLines = 1,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
                Spacer(modifier = modifier.height(4.dp))
                article.title?.let {
                    Text(
                        text = it,
                        maxLines = 3,
                        fontWeight = FontWeight.Thin,
                        fontSize = 16.sp
                    )
                }
                Spacer(modifier = modifier.height(4.dp))
                Text(
                    text = article.author ?: "UnKnown",
                    maxLines = 1,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                )
            }
        }
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
        )
    }
}

@Preview
@Composable
fun ArticlePreview() {
    // NewsCard()
    // ArticleCard()
}
