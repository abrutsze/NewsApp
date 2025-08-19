package com.project.models


data class UiArticle(
    val id: Int,
    val title: String,
    val description: String,
    val coverImage: String?,
    val url: String,
    val publishedTimestamp: String,
    val bodyHtml: String,
    val tagList: List<String>,
    val user: UiUser?
)