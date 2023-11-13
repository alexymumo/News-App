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
package com.alexmumo.presentation.bookmarks.view

import androidx.compose.foundation.clickable
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
import com.alexmumo.database.entity.BookMarkEntity

@Composable
fun BookMarkCard(
    bookMarkEntity: BookMarkEntity
    // onNavigate: (BookMarkEntity) -> Unit
) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(4.dp)
            .clickable {
                // onNavigate(bookMarkEntity)
            }
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context)
                .data(bookMarkEntity.urlToImage)
                .crossfade(true)
                .build(),
            contentDescription = "image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(130.dp).clip(RoundedCornerShape(8.dp))
        )
        Spacer(modifier = Modifier.width(2.dp))
        Column {
            Text(
                text = bookMarkEntity.description ?: "UnKnown",
                maxLines = 1,
                fontSize = 16.sp,
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Normal
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row {
                Text(
                    text = bookMarkEntity.author ?: "UnKnown",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    color = MaterialTheme.colorScheme.onPrimary
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = bookMarkEntity.sourceEntity.name ?: "UnKnown",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }
    Divider(
        modifier = Modifier.fillMaxWidth(),
        thickness = 1.dp,
        color = MaterialTheme.colorScheme.onPrimary
    )
}

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
            .testTag("bookmark_tag"),
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
            Spacer(modifier = Modifier.width(4.dp))
            Column {
                Text(
                    text = bookMarkEntity.description ?: "Null",
                    maxLines = 1,
                    fontSize = 16.sp,
                    modifier = Modifier.fillMaxWidth(),
                    fontWeight = FontWeight.Normal
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row {
                    Text(
                        text = bookMarkEntity.author ?: "UnKnown",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = bookMarkEntity.sourceEntity.name ?: "UnKnown",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun BookMarkItemPreview() {
    // BookMarkCard()
    // BookMarkItem()
}
