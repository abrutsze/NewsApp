package com.project.shared.data

import app.cash.turbine.test
import com.project.network.ktor.datasource.ArticlesDataSource
import com.project.response.ArticleResponse
import com.project.shared.feature.detail.data.ArticleDetailRepositoryImpl
import com.project.shared.mapper.toUiArticle
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals


class ArticleDetailRepositoryImplTest {

    @Test
    fun `getArticleById should map DomainArticle to UiArticle`() = runTest {

        val domainArticleDetail =  FakeResponseFactory.createArticleDetailResponse(1)
        val expectedUi = domainArticleDetail.toUiArticle()

        val fakeDataSource = object : ArticlesDataSource {
            override fun getArticleById(id: Int) = flowOf(domainArticleDetail)

            override fun getArticles() = flowOf(emptyList<ArticleResponse>())
        }

        val repository = ArticleDetailRepositoryImpl(fakeDataSource)

        repository.getArticleById(1).test {
            assertEquals(expectedUi, awaitItem())
            awaitComplete()
        }
    }
}