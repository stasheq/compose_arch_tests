package me.szymanski.composemtest

import me.szymanski.composemtest.core.coreModule
import me.szymanski.composemtest.navigation.NavigationViewModel
import me.szymanski.composemtest.navigation.Navigator
import me.szymanski.composemtest.screens.details.DetailsScreenViewModel
import me.szymanski.composemtest.screens.list.ListScreenViewModel
import org.koin.core.KoinApplication
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

fun KoinApplication.koinModules() {
    modules(
        coreModule,
        module {
            singleOf(::Navigator)
            viewModelOf(::NavigationViewModel)
            viewModelOf(::ListScreenViewModel)
            viewModelOf(::DetailsScreenViewModel)
        }
    )
}
