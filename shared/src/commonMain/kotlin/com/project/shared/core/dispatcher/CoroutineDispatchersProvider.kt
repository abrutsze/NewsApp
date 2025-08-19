package com.project.shared.core.dispatcher

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

internal class CoroutineDispatchersProvider :
    DispatchersProvider {
    override val main by lazy { Dispatchers.Main }
    override val io by lazy { Dispatchers.IO }
}