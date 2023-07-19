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
    Source("id","name"),
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