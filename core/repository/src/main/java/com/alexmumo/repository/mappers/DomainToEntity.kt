package com.alexmumo.repository.mappers

import com.alexmumo.database.entity.SourceEntity
import com.alexmumo.domain.model.Source

/*
internal fun Article.toEntity(): BookMarkEntity {
    return BookMarkEntity(
        this.author,
        this.content,
        this.description,
        this.publishedAt,
        this.source.toSourceEntity(),
        this.title,
        this.url,
        this.urlToImage
    )
}

 */

fun Source.toSourceEntity(): SourceEntity {
    return SourceEntity(
        this.id,
        this.name
    )
}
