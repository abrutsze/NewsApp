package com.project.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleResponse(
    @SerialName("canonical_url")
    val canonicalUrl: String?,
    @SerialName("comments_count")
    val commentsCount: Int?,
    @SerialName("cover_image")
    val coverImage: String?,
    @SerialName("created_at")
    val createdAt: String?,
    @SerialName("description")
    val description: String?,
    @SerialName("flare_tag")
    val flareTag: FlareTagResponse?,
    @SerialName("id")
    val id: Int?,
    @SerialName("language")
    val language: String?,
    @SerialName("last_comment_at")
    val lastCommentAt: String?,
    @SerialName("path")
    val path: String?,
    @SerialName("positive_reactions_count")
    val positiveReactionsCount: Int?,
    @SerialName("public_reactions_count")
    val publicReactionsCount: Int?,
    @SerialName("published_at")
    val publishedAt: String?,
    @SerialName("published_timestamp")
    val publishedTimestamp: String?,
    @SerialName("readable_publish_date")
    val readablePublishDate: String?,
    @SerialName("reading_time_minutes")
    val readingTimeMinutes: Int?,
    @SerialName("slug")
    val slug: String?,
    @SerialName("social_image")
    val socialImage: String?,
    @SerialName("subforem_id")
    val subforemId: Int?,
    @SerialName("tag_list")
    val tagList: List<String>?,
    @SerialName("body_html")
    val bodyHtml: String?,
    @SerialName("tags")
    val tags: String?,
    @SerialName("title")
    val title: String?,
    @SerialName("type_of")
    val typeOf: String?,
    @SerialName("url")
    val url: String?,
    @SerialName("user")
    val user: UserResponse?
)