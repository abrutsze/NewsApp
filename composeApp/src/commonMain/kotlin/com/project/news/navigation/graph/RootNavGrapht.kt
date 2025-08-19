package com.project.news.navigation.graph

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.project.news.ui.detail.ArticleDetailScreen
import com.project.news.ui.article.ArticleScreen

import com.project.screens.AppScreens
import com.project.screens.Navigation
import com.project.screens.Screens

@Composable
fun RootNavGraph(
    modifier: Modifier = Modifier,
    startDestination: Screens = AppScreens.Home
) {

    val rootNavController: NavHostController = rememberNavController()
    fun navigate(navigation: Navigation) {
        when (navigation) {
            is Navigation.Back -> rootNavController.popBackStack()
            is Navigation.BackTo -> {
                rootNavController.popBackStack(route = navigation.screen, false)
                navigation.payload?.entries?.forEach { entry ->
                    rootNavController.currentBackStackEntry?.savedStateHandle?.set(entry.key, entry.value)
                }
            }
            is AppScreens -> rootNavController.navigate(navigation)
        }
    }

    NavHost(
        navController = rootNavController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        composable<AppScreens.Home> {
            ArticleScreen(::navigate)
        }

        composable<AppScreens.ArticleDetail> { backStackEntry ->
            val article: AppScreens.ArticleDetail = backStackEntry.toRoute()
            ArticleDetailScreen(
                article.id,
                navigate = ::navigate
            )
        }
    }



}
