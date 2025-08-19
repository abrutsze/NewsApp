package com.project.network.ktor.datasource

import com.project.response.ArticleDetailResponse
import com.project.response.ArticleResponse
import kotlinx.coroutines.flow.Flow

interface ArticlesDataSource {
     fun getArticles(): Flow<List<ArticleResponse>>
     fun getArticleById(id: Int): Flow<ArticleDetailResponse>
}
