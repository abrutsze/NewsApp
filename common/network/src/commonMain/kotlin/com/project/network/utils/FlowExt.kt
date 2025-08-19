package com.project.network.utils

import kotlinx.coroutines.flow.flow

inline fun <T> emitFlow(crossinline action: suspend () -> T) = flow { emit(action.invoke()) }