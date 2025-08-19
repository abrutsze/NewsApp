package com.project.mvvm

import androidx.compose.runtime.Stable

@Stable
interface UiEffect {
    data class ShowNoInternetConnection(val retry: () -> Unit = {}) : UiEffect
    data class ShowDefaultError(val message: String) : UiEffect
}