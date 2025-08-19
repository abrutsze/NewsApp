package com.project.screens

import androidx.annotation.IntDef
import androidx.compose.runtime.Stable
import kotlinx.serialization.Serializable

@Stable
@Serializable
sealed class AppScreens : Screens() {

    @Stable
    @Serializable
    data object Home : AppScreens()

    @Stable
    @Serializable
    data class ArticleDetail(val id: Int) : AppScreens()
}
