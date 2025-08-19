package com.project.shared.di

import com.project.shared.feature.homepage.HomaPageViewModel
import com.project.shared.feature.detail.ArticleDetailViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module


internal val viewModelModule = module {
    viewModelOf(::HomaPageViewModel)
    viewModelOf(::ArticleDetailViewModel)
}