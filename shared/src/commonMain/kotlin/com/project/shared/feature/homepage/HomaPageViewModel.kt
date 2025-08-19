package com.project.shared.feature.homepage

import androidx.lifecycle.viewModelScope
import com.project.mvvm.BaseViewModel
import com.project.shared.feature.homepage.domain.GetArticlesUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class HomaPageViewModel :
    BaseViewModel<HomePageState, HomePageEffect>(HomePageState()), KoinComponent{

    private val playbackMediaUseCase: GetArticlesUseCase by inject()

    init {
        fetchData()
    }

    fun fetchData() {
        playbackMediaUseCase().onEach {
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