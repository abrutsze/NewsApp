package com.project.news.ui.article

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.project.news.component.TopArticleCard
import com.project.news.component.ArticleCard
import com.project.screens.Navigation
import com.project.shared.feature.homepage.HomaPageViewModel
import com.project.news.ui.view.ErrorScreen
import com.project.screens.AppScreens
import com.project.shared.feature.homepage.HomePageState
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ArticleScreen(
    navigate: (Navigation) -> Unit
) {
    val viewModel = koinViewModel<HomaPageViewModel>()

    val state = viewModel.viewState
    when {
        state.error != null -> {
            ErrorScreen(onRetry = { viewModel.fetchData() })
        }

        state.loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        else -> {
            ArticleContent(state, navigate)
        }
    }
}

@Composable
private fun ArticleContent(state: HomePageState, navigate: (Navigation) -> Unit) {
    val topArticle = state.data?.first
    val list = state.data?.second.orEmpty()

    LazyColumn(modifier = Modifier.padding(bottom = 16.dp)) {
        topArticle?.let { article ->
            item {
                TopArticleCard(
                    title = article.title,
                    description = article.description,
                    imageUrl = article.coverImage
                ) {
                    navigate(AppScreens.ArticleDetail(article.id))
                }
            }
        }

        items(list) { item ->
            ArticleCard(
                title = item.title,
                imageUrl = item.coverImage,
            ) {
                navigate(AppScreens.ArticleDetail(item.id))
            }
        }
    }
}