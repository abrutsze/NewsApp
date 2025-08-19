package com.project.shared.mapper

import com.project.models.UiArticle
import com.project.response.ArticleDetailResponse
import com.project.response.ArticleResponse
import com.project.shared.core.utils.orDefault

fun ArticleResponse.toUiArticle(): UiArticle =
    UiArticle(
        id = id.orDefault(),
        title = title.orEmpty(),
        description = description.orEmpty(),
        coverImage = coverImage ?: socialImage,
        url = url.orEmpty(),
        bodyHtml = bodyHtml.orEmpty(),
        publishedTimestamp = readablePublishDate.orEmpty(),
        tagList = tagList.orEmpty(),
        user = user?.toUiUser()
    )

fun ArticleDetailResponse.toUiArticle(): UiArticle =
    UiArticle(
        id = id.orDefault(),
        title = title.orEmpty(),
        description = description.orEmpty(),
        coverImage = coverImage ?: socialImage,
        url = url.orEmpty(),
        bodyHtml = bodyHtml.orEmpty(),
        publishedTimestamp = readablePublishDate.orEmpty(),
        tagList = tagList.orEmpty(),
        user = user?.toUiUser()
    )
