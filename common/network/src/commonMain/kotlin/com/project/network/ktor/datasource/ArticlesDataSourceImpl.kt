package com.project.network.ktor.datasource


import com.project.network.utils.emitFlow
import com.project.response.ArticleDetailResponse
import com.project.response.ArticleResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url
import kotlinx.coroutines.flow.Flow

internal class ArticlesDataSourceImpl(private val httpClient: HttpClient) : ArticlesDataSource {
    private val articlesEndPoint = "articles"
    private val articleEndPoint = "articles"

    override fun getArticles():Flow<List<ArticleResponse>> = emitFlow {
        httpClient.get(articlesEndPoint) {
            parameter("page", 1)
            parameter("per_page", 20)
        }.body()
    }

    override fun getArticleById(id: Int): Flow<ArticleDetailResponse> = emitFlow {
        httpClient.get {
            url("$articleEndPoint/$id")
        }.body()
    }
}
