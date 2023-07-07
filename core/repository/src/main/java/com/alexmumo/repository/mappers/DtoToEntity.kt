package com.alexmumo.repository.mappers

import com.alexmumo.database.entity.ArticleEntity
import com.alexmumo.database.entity.SourceEntity
import com.alexmumo.network.dto.ArticleDto
import com.alexmumo.network.dto.SourceDto

internal fun ArticleDto.toEntity() : ArticleEntity {
    return ArticleEntity(
        this.author,
        this.content,
        this.description,
        this.publishedAt,
        this.title,
        this.source.toSourceEntity(),
        this.url,
        this.urlToImage
    )
}

internal fun SourceDto.toSourceEntity(): SourceEntity {
    return SourceEntity(
        this.id,
        this.name
    )
}