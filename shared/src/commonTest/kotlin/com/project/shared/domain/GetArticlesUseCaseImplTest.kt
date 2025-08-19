package com.project.shared.domain

import app.cash.turbine.test
import com.project.models.UiArticle
import com.project.shared.core.dispatcher.DispatchersProvider
import com.project.shared.feature.homepage.data.ArticlesRepository
import com.project.shared.feature.homepage.domain.GetArticlesUseCaseImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class GetArticlesUseCaseImplTest {

    private val testDispatcher = UnconfinedTestDispatcher()

    private val dispatcherProvider = object : DispatchersProvider {
        override val io = testDispatcher
        override val main = testDispatcher
    }

    @Test
    fun `invoke should split top and other articles`() = runTest {
        // given
        val article1 =  UiArticle(
            id = 1,
            title = "Test1",
            description = "Test1",
            coverImage = null,
            url = "",
            publishedTimestamp = "",
            bodyHtml = "",
            tagList = emptyList(),
            user = null
        )
        val article2 = UiArticle(
            id = 2,
            title = "Test2",
            description = "Test2",
            coverImage = null,
            url = "",
            publishedTimestamp = "",
            bodyHtml = "",
            tagList = emptyList(),
            user = null
        )
        val article3 =  UiArticle(
            id = 3,
            title = "Test3",
            description = "Test3",
            coverImage = null,
            url = "",
            publishedTimestamp = "",
            bodyHtml = "",
            tagList = emptyList(),
            user = null
        )

        val fakeRepository = object : ArticlesRepository {
            override fun getArticles() = flowOf(listOf(article1, article2, article3))
        }

        val useCase = GetArticlesUseCaseImpl(fakeRepository, dispatcherProvider)

        // when + then
        useCase().test {
            val (top, list) = awaitItem()
            assertEquals(article1, top)
            assertEquals(listOf(article2, article3), list)
            awaitComplete()
        }
    }

    @Test
    fun `invoke should return null top and empty list when no articles`() = runTest {

        val fakeRepository = object : ArticlesRepository {
            override fun getArticles() = flowOf(emptyList<UiArticle>())
        }

        val useCase = GetArticlesUseCaseImpl(fakeRepository, dispatcherProvider)

        useCase().test {
            val (top, list) = awaitItem()

            assertEquals(null, top)
            assertEquals(emptyList<UiArticle>(), list)
            awaitComplete()
        }
    }
}