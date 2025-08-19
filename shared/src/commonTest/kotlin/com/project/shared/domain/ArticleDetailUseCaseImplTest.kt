package com.project.shared.domain

import app.cash.turbine.test
import com.project.models.UiArticle
import com.project.shared.core.dispatcher.DispatchersProvider
import com.project.shared.feature.detail.data.ArticleDetailRepository
import com.project.shared.feature.detail.domain.ArticleDetailUseCaseImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.flow.flowOf
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class ArticleDetailUseCaseImplTest {

    private val testDispatcher = UnconfinedTestDispatcher()

    @Test
    fun `invoke should return UiArticle from repository`() = runTest {
        // given
        val expectedArticle = UiArticle(
            id = 1,
            title = "Test",
            description = "Test",
            coverImage = null,
            url = "",
            publishedTimestamp = "",
            bodyHtml = "",
            tagList = emptyList(),
            user = null
        )
        val fakeRepository = object : ArticleDetailRepository {
            override fun getArticleById(id: Int) = flowOf(expectedArticle)
        }
        val dispatcherProvider = object : DispatchersProvider {
            override val io = testDispatcher
            override val main = testDispatcher
        }

        val useCase = ArticleDetailUseCaseImpl(fakeRepository, dispatcherProvider)

        // when + then
        useCase(1).test {
            assertEquals(expectedArticle, awaitItem())
            awaitComplete()
        }
    }
}