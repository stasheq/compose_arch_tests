package me.szymanski.composemtest.screens.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import composemtest.composeapp.generated.resources.Res
import composemtest.composeapp.generated.resources.detail_branch
import composemtest.composeapp.generated.resources.detail_description
import composemtest.composeapp.generated.resources.detail_forks
import composemtest.composeapp.generated.resources.detail_issues
import composemtest.composeapp.generated.resources.detail_language
import composemtest.composeapp.generated.resources.detail_license
import composemtest.composeapp.generated.resources.detail_name
import composemtest.composeapp.generated.resources.detail_owner
import composemtest.composeapp.generated.resources.detail_private
import composemtest.composeapp.generated.resources.detail_watchers
import composemtest.composeapp.generated.resources.loading_details_error
import me.szymanski.composemtest.core.data.DetailType
import me.szymanski.composemtest.core.usecase.GetDetailsUseCase
import me.szymanski.composemtest.navigation.NavigationScreen
import me.szymanski.composemtest.screens.details.data.DetailsItem
import me.szymanski.composemtest.utils.combine
import me.szymanski.composemtest.utils.map

class DetailsScreenViewModel(
    private val detailsUseCase: GetDetailsUseCase
) : ViewModel() {

    val items = detailsUseCase.items.map(viewModelScope) { list ->
        list.map { DetailsItem(it.type.name, it.type.toTitle(), it.value) }
    }
    val listVisible = combine(detailsUseCase.loading, detailsUseCase.error, viewModelScope) { loading, error -> !error && !loading }
    val isLoading = detailsUseCase.loading
    val title = detailsUseCase.title
    val error = detailsUseCase.error.map(viewModelScope) { if (it) Res.string.loading_details_error else null }

    private fun DetailType.toTitle() = when (this) {
        DetailType.NAME -> Res.string.detail_name
        DetailType.DESCRIPTION -> Res.string.detail_description
        DetailType.PRIVATE -> Res.string.detail_private
        DetailType.OWNER -> Res.string.detail_owner
        DetailType.FORKS -> Res.string.detail_forks
        DetailType.LANGUAGE -> Res.string.detail_language
        DetailType.ISSUES -> Res.string.detail_issues
        DetailType.LICENSE -> Res.string.detail_license
        DetailType.WATCHERS -> Res.string.detail_watchers
        DetailType.BRANCH -> Res.string.detail_branch
    }

    fun setArgs(args: NavigationScreen.Details) {
        detailsUseCase.loadDetails(viewModelScope, args.owner, args.name, false)
    }

    fun onBackClick() {
        // TODO
    }
}
