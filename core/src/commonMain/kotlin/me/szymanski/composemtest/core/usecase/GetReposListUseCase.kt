package me.szymanski.composemtest.core.usecase

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import me.szymanski.composemtest.core.Config
import me.szymanski.composemtest.core.api.RestApi
import me.szymanski.composemtest.core.api.data.ApiError
import me.szymanski.composemtest.core.data.ErrorType
import me.szymanski.composemtest.core.data.Repository
import kotlin.time.Duration.Companion.seconds

class GetReposListUseCase(
    private val restApi: RestApi,
) : LoadPagedListUseCase<Repository, Int, ErrorType>(1) {

    var userName = Config.INITIAL_USER
    private var updateUserNameDebounceJob: Job? = null

    fun onUserNameInput(scope: CoroutineScope, user: String) {
        if (userName == user) return
        updateUserNameDebounceJob?.cancel()
        updateUserNameDebounceJob = scope.launch {
            delay(1.seconds)
            userName = user
            if (user.isNotBlank()) loadNextPage(scope, true)
        }
    }

    override suspend fun getPage(page: Int): LoadingResult<Repository> {
        val result = restApi.getRepositories(userName, page).map { Repository(it) }
        return LoadingResult(result, result.size == Config.Api.PAGE_SIZE)
    }

    override fun mapError(e: ApiError): ErrorType = when {
        e is ApiError.HttpErrorResponse && e.code == 404 -> ErrorType.USER_DOESNT_EXIST
        e is ApiError.NoConnection -> ErrorType.NO_CONNECTION
        else -> ErrorType.OTHER
    }

    override fun nextPageInfo(page: Int): Int = page + 1
}
