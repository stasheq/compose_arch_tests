package me.szymanski.composemtest.screens.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import composemtest.composeapp.generated.resources.Res
import composemtest.composeapp.generated.resources.loading_error_doesnt_exist
import composemtest.composeapp.generated.resources.loading_error_other
import me.szymanski.composemtest.core.data.ErrorType
import me.szymanski.composemtest.core.data.Repository
import me.szymanski.composemtest.core.usecase.GetReposListUseCase
import me.szymanski.composemtest.utils.combine
import me.szymanski.composemtest.utils.map
import me.szymanski.composemtest.view.data.TitleDescriptionClickableItem

class ListScreenViewModel(
    private val reposUseCase: GetReposListUseCase
) : ViewModel() {

    init {
        reload()
    }

    private var afterPullToRefresh = false

    val userName = reposUseCase.userName
    val centerLoading = reposUseCase.loading.map(viewModelScope) {
        it && !afterPullToRefresh
    }
    val pullLoading = reposUseCase.loading.map(viewModelScope) {
        it && afterPullToRefresh
    }
    val error = reposUseCase.error.map(viewModelScope) {
        when (it) {
            ErrorType.USER_DOESNT_EXIST -> Res.string.loading_error_doesnt_exist
            ErrorType.OTHER -> Res.string.loading_error_other
            null -> null
        }
    }
    val items = reposUseCase.list.map(viewModelScope) {
        it?.mapToUI() ?: emptyList()
    }
    val listVisible = combine(centerLoading, error, viewModelScope) { loading, error ->
        error == null && !loading
    }

    val hasNextPage = reposUseCase.hasNextPage

    fun onPullToRefresh() {
        afterPullToRefresh = true
        reload()
    }

    fun reload() = reposUseCase.loadNextPage(viewModelScope, true)

    fun loadNextPage() = reposUseCase.loadNextPage(viewModelScope, false)

    private fun List<Repository>.mapToUI() = map {
        TitleDescriptionClickableItem(it.id, it.name, it.description) { }
    }

    fun onValueChange(value: String) {
        reposUseCase.onUserNameInput(viewModelScope, value)
    }
}
