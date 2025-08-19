package com.project.mvvm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<S : UiState, E : UiEffect>(initState: S) : ViewModel() {

    var viewState by mutableStateOf(initState)
        protected set

    private val _effects = Channel<E>()
    val effects = _effects.receiveAsFlow()

    protected fun updateState(transform: S.() -> S) {
        viewState = viewState.transform()
    }

    protected fun sendEffect(effect: E) {
        viewModelScope.launch {
            _effects.send(effect)
        }
    }
}