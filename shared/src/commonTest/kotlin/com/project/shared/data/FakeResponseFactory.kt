package com.project.shared.data

import com.project.response.ArticleDetailResponse
import com.project.response.ArticleResponse

object FakeResponseFactory {

    fun createArticleResponse(id:Int): ArticleResponse {
        return ArticleResponse(
            canonicalUrl = null,
            commentsCount = 5,
            coverImage = null,
            createdAt = "2025-01-01T10:00:00Z",
            description = "Photo by Ningyu He on Unsplash   Installing different packages and frameworks means you run into som...",
            flareTag = null,
            id = id,
            language = "en",
            lastCommentAt = "2025-01-02T12:00:00Z",
            path = null,
            positiveReactionsCount = 42,
            publicReactionsCount = 50,
            publishedAt = "2025-01-01T12:00:00Z",
            publishedTimestamp = "2025-01-01T12:00:00Z",
            readablePublishDate = "Jan 1",
            readingTimeMinutes = 3,
            slug = "use-custom-html-attribute-s-in-typescript-2co",
            socialImage = "https://example.com/fake-social.png",
            subforemId = 123,
            tagList = listOf("kotlin", "testing"),
            bodyHtml = null,
            tags = "kotlin,testing",
            title = "Use Custom HTML Attribute's in TypeScript",
            typeOf = "article",
            url = "https://dev.to/lukethacoder/use-custom-html-attribute-s-in-typescript-2co",
            user = null
        )
    }

    fun createArticleDetailResponse(id:Int): ArticleDetailResponse {
        return ArticleDetailResponse(
            canonicalUrl = null,
            commentsCount = 5,
            coverImage = null,
            createdAt = "2025-01-01T10:00:00Z",
            description = "Photo by Ningyu He on Unsplash   Installing different packages and frameworks means you run into som...",
            flareTag = null,
            id = id,
            language = "en",
            lastCommentAt = "2025-01-02T12:00:00Z",
            path = null,
            positiveReactionsCount = 42,
            publicReactionsCount = 50,
            publishedAt = "2025-01-01T12:00:00Z",
            publishedTimestamp = "2025-01-01T12:00:00Z",
            readablePublishDate = "Jan 1",
            readingTimeMinutes = 3,
            slug = "use-custom-html-attribute-s-in-typescript-2co",
            socialImage = "https://example.com/fake-social.png",
            subforemId = 123,
            tagList = listOf("kotlin", "testing"),
            bodyHtml = null,
            title = "Use Custom HTML Attribute's in TypeScript",
            typeOf = "article",
            url = "https://dev.to/lukethacoder/use-custom-html-attribute-s-in-typescript-2co",
            user = null
        )
    }
}