package com.project.news

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.project.news.navigation.graph.RootNavGraph
import com.project.shared.di.externalSharedModule
import org.koin.compose.KoinApplication

@Composable
fun ProjectApp() {
    KoinApplication(application = {
        modules(externalSharedModule)
    }) {
        MaterialTheme {
            RootNavGraph()
        }
    }
}
