package com.project.shared.data

import app.cash.turbine.test
import com.project.network.ktor.datasource.ArticlesDataSource
import com.project.response.ArticleDetailResponse
import com.project.response.ArticleResponse
import com.project.shared.feature.homepage.data.ArticlesRepositoryImpl
import com.project.shared.mapper.toUiArticle
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class ArticlesRepositoryImplTest {

    @Test
    fun `getArticles should map ArticleResponse to UiArticle`() = runTest {

        val domainArticles = listOf(
            FakeResponseFactory.createArticleResponse(1),
            FakeResponseFactory.createArticleResponse(2)
        )

        val domainArticleDetail =  FakeResponseFactory.createArticleDetailResponse(1)
        val expectedUiArticles = domainArticles.map { it.toUiArticle() }

        val fakeDataSource = object : ArticlesDataSource {
            override fun getArticles(): Flow<List<ArticleResponse>> = flowOf(domainArticles)
            override fun getArticleById(id: Int): Flow<ArticleDetailResponse> =
                flowOf(domainArticleDetail)
        }

        val repository = ArticlesRepositoryImpl(fakeDataSource)

        // when + then
        repository.getArticles().test {
            val result = awaitItem()
            assertEquals(expectedUiArticles, result)
            awaitComplete()
        }
    }
}