package com.alexmumo.database.data

import com.alexmumo.database.entity.BookMarkEntity
import com.alexmumo.database.entity.SourceEntity

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
