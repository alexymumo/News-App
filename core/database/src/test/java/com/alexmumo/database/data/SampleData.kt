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
package com.alexmumo.database.data

import com.alexmumo.database.entity.ArticleEntity
import com.alexmumo.database.entity.BookMarkEntity
import com.alexmumo.database.entity.RemoteKeyEntity
import com.alexmumo.database.entity.SourceEntity

val articleEntity = ArticleEntity(
    "test",
    "test",
    "test",
    "test",
    "",
    SourceEntity(
        "test",
        "test"
    ),
    "test",
    "url"
)

val remoteKeyEntity = RemoteKeyEntity(
    "test",
    1,
    2
)

val bookMarkEntity = BookMarkEntity(
    "alex",
    "test content",
    "this is test news",
    "12-0-2023",
    SourceEntity(
        "id",
        "name test"
    ),
    "Breaking news",
    "news.url",
    "urlToImage",
    false
)
