package com.project.mvvm

import androidx.compose.runtime.Immutable

@Immutable
interface UiState {
    val error: String?
}