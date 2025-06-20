package me.szymanski.composemtest.core.usecase

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import me.szymanski.composemtest.core.api.RestApi
import me.szymanski.composemtest.core.data.DetailType
import me.szymanski.composemtest.core.data.RepositoryDetail
import me.szymanski.composemtest.core.data.RepositoryDetails
import me.szymanski.composemtest.core.log.Logger
import me.szymanski.composemtest.core.log.logError

class GetDetailsUseCase(
    private val logger: Logger,
    private val restApi: RestApi
) {
    val loading = MutableStateFlow(true)
    val error = MutableStateFlow(false)
    val items = MutableStateFlow(emptyList<RepositoryDetail>())
    val title = MutableStateFlow("")

    private var lastJob: Job? = null
    private var lastRepository: String? = null

    fun loadDetails(scope: CoroutineScope, owner: String, name: String, force: Boolean) {
        val newRepository = "${owner}/${name}"
        if (lastRepository == newRepository && !force) {
            return
        }
        title.value = newRepository
        lastJob?.cancel()

        loading.value = true
        lastRepository = newRepository
        lastJob = scope.launch {
            runCatching {
                val details = RepositoryDetails(restApi.getRepository(owner, name))
                loading.value = false
                error.value = false
                items.value = toDetailsItems(details)
            }.onFailure {
                logger.logError("Error loading repository details", it)
                loading.value = false
                error.value = true
            }
        }
    }

    private fun toDetailsItems(repo: RepositoryDetails): List<RepositoryDetail> = listOf(
        RepositoryDetail(DetailType.NAME, repo.name),
        RepositoryDetail(DetailType.DESCRIPTION, repo.description ?: ""),
        RepositoryDetail(DetailType.LANGUAGE, repo.language ?: ""),
        RepositoryDetail(DetailType.PRIVATE, "${repo.private}"),
        RepositoryDetail(DetailType.OWNER, repo.owner),
        RepositoryDetail(DetailType.FORKS, "${repo.forks}"),
        RepositoryDetail(DetailType.ISSUES, "${repo.openIssues}"),
        RepositoryDetail(DetailType.LICENSE, repo.license ?: ""),
        RepositoryDetail(DetailType.BRANCH, repo.defaultBranch),
        RepositoryDetail(DetailType.WATCHERS, "${repo.watchers}")
    )
}
