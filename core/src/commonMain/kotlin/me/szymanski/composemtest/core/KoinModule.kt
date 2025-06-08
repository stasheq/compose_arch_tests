package me.szymanski.composemtest.core

import me.szymanski.composemtest.core.api.RestApi
import me.szymanski.composemtest.core.api.createHttpClient
import me.szymanski.composemtest.core.usecase.GetDetailsUseCase
import me.szymanski.composemtest.core.usecase.GetReposListUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val coreModule = module {
    single { createHttpClient() }
    factoryOf(::RestApi)
    factoryOf(::GetReposListUseCase)
    factoryOf(::GetDetailsUseCase)
}
