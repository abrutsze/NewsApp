package com.project.network.ktor

import io.ktor.client.engine.*
import io.ktor.client.engine.darwin.Darwin

actual class HttpEngineFactory actual constructor() {
    actual fun createEngine(): HttpClientEngineFactory<HttpClientEngineConfig> = Darwin
}