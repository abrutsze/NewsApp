package com.project.shared.feature.homepage

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.project.models.UiArticle
import com.project.mvvm.UiEffect
import com.project.mvvm.UiState

@Stable
sealed class HomePageEffect : UiEffect {
    data object ShowDetailScreen : HomePageEffect()
}

@Immutable
data class HomePageState(
    override val error: String? = null,
    val loading: Boolean = true,
    val data:  Pair<UiArticle?, List<UiArticle>>? = null,
) : UiState