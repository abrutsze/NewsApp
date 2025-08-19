package com.project.shared.feature.homepage.data

import com.project.models.UiArticle
import com.project.network.ktor.datasource.ArticlesDataSource
import com.project.shared.mapper.toUiArticle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface ArticlesRepository {
    fun getArticles(): Flow<List<UiArticle>>
}

internal class ArticlesRepositoryImpl(private val dataSource: ArticlesDataSource) :
    ArticlesRepository {

    override fun getArticles(): Flow<List<UiArticle>> =
        dataSource.getArticles().map { it.map { it.toUiArticle() } }

}
