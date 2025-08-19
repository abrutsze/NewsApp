package com.project.shared.feature.homepage.domain

import com.project.models.UiArticle
import com.project.shared.core.dispatcher.DispatchersProvider
import com.project.shared.feature.homepage.data.ArticlesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

interface GetArticlesUseCase {
    operator fun invoke(): Flow<Pair<UiArticle?, List<UiArticle>>>
}

internal class  GetArticlesUseCaseImpl(
    private val repository: ArticlesRepository,
    private val dispatcher: DispatchersProvider
) : GetArticlesUseCase {

    override operator fun invoke(): Flow<Pair<UiArticle?, List<UiArticle>>> {
        return repository.getArticles().map {
            splitTopArticleAndList(it)
        }.flowOn(dispatcher.io)
    }

   private fun splitTopArticleAndList(articles: List<UiArticle>): Pair<UiArticle?, List<UiArticle>> {
        if (articles.isEmpty()) return null to emptyList()

        val top = articles.first()
        val list = articles.drop(1)

        return top to list
    }
}