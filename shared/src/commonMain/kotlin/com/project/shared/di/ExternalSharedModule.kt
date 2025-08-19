package com.project.shared.di

import com.project.network.di.networkModule
import com.project.shared.platform.di.platformCoreModule
import org.koin.core.module.Module
import org.koin.dsl.module


val externalSharedModule: Module
    get() = module {
        includes(
            internalDataModule  +
                    internalUseCaseModule +
                    platformCoreModule +
                    viewModelModule +
                    networkModule

        )
    }