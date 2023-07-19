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

internal fun SourceDto.toSource(): Source {
    return Source(
        this.id,
        this.name
    )
}
