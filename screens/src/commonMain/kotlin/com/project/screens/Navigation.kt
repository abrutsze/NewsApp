package com.project.screens

import androidx.compose.runtime.Stable
import kotlinx.serialization.Serializable

@Stable
interface  Navigation {

    @Stable
    @Serializable
    data object Back : Navigation

    @Stable
    @Serializable
    data class BackTo(
        val screen: Screens,
        val exclusive:Boolean = false,
        val payload: Map<String, String>? = null
    ) : Navigation
}
