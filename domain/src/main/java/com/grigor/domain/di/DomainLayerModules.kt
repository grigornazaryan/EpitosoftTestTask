package com.grigor.domain.di

import com.grigor.domain.usecase.WellsListUseCase
import com.grigor.domain.usecaseHelper.WellsListUseCaseHelper
import org.koin.dsl.module

val domainLayerModules= module {
    factory<WellsListUseCaseHelper> {WellsListUseCase(get())  }
}