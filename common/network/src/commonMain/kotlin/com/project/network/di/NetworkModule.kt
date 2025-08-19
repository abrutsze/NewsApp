package com.project.network.di

import com.project.network.ktor.HttpEngineFactory
import com.project.network.ktor.datasource.ArticlesDataSource
import com.project.network.ktor.datasource.ArticlesDataSourceImpl
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import  io.ktor.client.plugins.logging.DEFAULT
import  io.ktor.client.plugins.logging.Logger
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val networkModule = module {
    val baseUrl = "dev.to/api"

    fun provideJson() = Json {
        prettyPrint = true
        isLenient = true
        ignoreUnknownKeys = true
        explicitNulls = false
        useAlternativeNames = false
    }

    fun provideHttpClient(json: Json, engineFactory: HttpEngineFactory): HttpClient =
        HttpClient(engineFactory.createEngine()) {
            expectSuccess = true
            install(ContentNegotiation) {
                json(
                    json = json
                )
            }
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        println("Ktor $message")
                    }
                }
                level = LogLevel.ALL
            }
            defaultRequest {
                header(HttpHeaders.ContentType, ContentType.Application.Json)
                url {
                    protocol = URLProtocol.HTTPS
                    host = baseUrl
                }
                contentType(ContentType.Application.Json)
            }
        }

    single {HttpEngineFactory()}
    single {provideJson()}
    single {provideHttpClient(get(),get())}
    singleOf(::ArticlesDataSourceImpl) bind(ArticlesDataSource::class)
}





