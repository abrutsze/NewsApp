package com.project.shared.feature.detail.data

import com.project.models.UiArticle
import com.project.network.ktor.datasource.ArticlesDataSource
import com.project.shared.mapper.toUiArticle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface ArticleDetailRepository {
    fun getArticleById(id: Int): Flow<UiArticle>
}

internal class ArticleDetailRepositoryImpl(private val dataSource: ArticlesDataSource) :
    ArticleDetailRepository {
    override fun getArticleById(id: Int): Flow<UiArticle> = dataSource.getArticleById(id).map { it.toUiArticle() }
}
