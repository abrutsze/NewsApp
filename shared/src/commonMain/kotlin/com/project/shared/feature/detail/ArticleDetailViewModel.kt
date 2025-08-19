package com.project.shared.feature.detail

import androidx.lifecycle.viewModelScope
import com.project.mvvm.BaseViewModel
import com.project.mvvm.UiEffect
import com.project.shared.feature.detail.domain.ArticleDetailUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class ArticleDetailViewModel(val id: Int) :
    BaseViewModel<ArticleDetailState, UiEffect>(ArticleDetailState()), KoinComponent {

    private val articleDetailUseCase: ArticleDetailUseCase by inject()

    init {
        fetchData()
    }

    fun fetchData() {
        articleDetailUseCase(id)
            .onStart {
                updateState {
                    copy(
                        loading = true
                    )
                }
            }.onEach {
                updateState {
                    copy(
                        loading = false,
                        data = it
                    )
                }
            }.catch {
                updateState {
                    copy(
                        error = it.message,
                    )
                }
            }.launchIn(viewModelScope)
    }
}