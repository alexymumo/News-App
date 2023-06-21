package com.alexmumo.repository.mappers

import com.alexmumo.domain.model.Article
import com.alexmumo.domain.model.Source
import com.alexmumo.network.dto.ArticleDto
import com.alexmumo.network.dto.SourceDto

internal fun ArticleDto.toDomain(): Article {
    return Article(
        this.author,
        this.content,
        this.description,
        this.publishedAt,
        this.source.toSource(),
        this.title,
        this.url,
        this.urlToImage
    )
}

internal fun Article.toArticle() : ArticleDto {
    return ArticleDto(
        this.author,
        this.content,
        this.description,
        this.publishedAt,
        this.source.toSources(),
        this.title,
        this.url,
        this.urlToImage
    )
}

internal fun Source.toSources(): SourceDto {
    return SourceDto(this.id, this.name)
}

internal fun SourceDto.toSource(): Source {
    return Source(
        this.id,
        this.name
    )
}