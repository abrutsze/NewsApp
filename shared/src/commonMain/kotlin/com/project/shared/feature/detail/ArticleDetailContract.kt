package com.project.shared.feature.detail

import androidx.compose.runtime.Immutable
import com.project.models.UiArticle
import com.project.mvvm.UiState

@Immutable
data class ArticleDetailState(
    override val error: String? = null,
    val loading: Boolean = true,
    val data:  UiArticle? = null,
) : UiState