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
package com.alexmumo.presentation.data

import com.alexmumo.database.entity.BookMarkEntity
import com.alexmumo.database.entity.SourceEntity
import com.alexmumo.domain.model.Article
import com.alexmumo.domain.model.Source

val article = Article(
    "test",
    "",
    "it is description",
    "12 june",
    Source("id", "name"),
    "test title",
    "test.com",
    "url.com",
)

val sources = Source(
    "id",
    "test"
)
val source = SourceEntity(
    "id",
    "name"
)
val bookMark = BookMarkEntity(
    "test",
    "",
    "it is description",
    "12 june",
    source,
    "test title",
    "test.com",
    "url.com",
    false
)
