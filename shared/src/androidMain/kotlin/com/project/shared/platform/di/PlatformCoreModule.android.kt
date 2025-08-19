package com.project.shared.platform.di


import com.project.shared.platform.enum.OsType
import org.koin.core.module.Module
import org.koin.dsl.module

internal actual val platformCoreModule: Module = module {

    single<OsType> { OsType.ANDROID }

}
