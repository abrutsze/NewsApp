package com.project.shared.di

import com.project.shared.core.dispatcher.CoroutineDispatchersProvider
import com.project.shared.core.dispatcher.DispatchersProvider
import com.project.shared.feature.detail.data.ArticleDetailRepository
import com.project.shared.feature.detail.data.ArticleDetailRepositoryImpl
import com.project.shared.feature.homepage.data.ArticlesRepositoryImpl
import com.project.shared.feature.homepage.data.ArticlesRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

 internal val internalDataModule = module {
     singleOf(::CoroutineDispatchersProvider) bind(DispatchersProvider::class)
     singleOf(::ArticlesRepositoryImpl) bind(ArticlesRepository::class)
     singleOf(::ArticleDetailRepositoryImpl) bind(ArticleDetailRepository::class)
}