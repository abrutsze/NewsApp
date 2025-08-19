package com.project.shared.di

import com.project.shared.feature.detail.domain.ArticleDetailUseCase
import com.project.shared.feature.detail.domain.ArticleDetailUseCaseImpl
import com.project.shared.feature.homepage.domain.GetArticlesUseCaseImpl
import com.project.shared.feature.homepage.domain.GetArticlesUseCase

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

 internal val internalUseCaseModule = module {
     singleOf(::GetArticlesUseCaseImpl) bind(GetArticlesUseCase::class)
     singleOf(::ArticleDetailUseCaseImpl) bind(ArticleDetailUseCase::class)
}