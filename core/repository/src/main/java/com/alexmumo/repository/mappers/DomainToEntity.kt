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
