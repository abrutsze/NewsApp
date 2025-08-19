package com.project.shared.feature.detail.domain

import com.project.models.UiArticle
import com.project.shared.core.dispatcher.DispatchersProvider
import com.project.shared.feature.detail.data.ArticleDetailRepository
import com.project.shared.feature.homepage.data.ArticlesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

interface ArticleDetailUseCase {
    operator fun invoke(id: Int): Flow<UiArticle>
}

internal class  ArticleDetailUseCaseImpl(
    private val repository: ArticleDetailRepository,
    private val dispatcher: DispatchersProvider
) : ArticleDetailUseCase {

    override operator fun invoke(id: Int): Flow<UiArticle> {
        return repository.getArticleById(id).flowOn(dispatcher.io)
    }
}