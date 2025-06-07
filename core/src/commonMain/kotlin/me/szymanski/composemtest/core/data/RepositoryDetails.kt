package me.szymanski.composemtest.core.data

import me.szymanski.composemtest.core.api.data.ApiRepositoryDetails

data class RepositoryDetails(
    val id: String,
    val name: String,
    val description: String?,
    val private: Boolean,
    val owner: String,
    val forks: Int,
    val language: String?,
    val openIssues: Int,
    val license: String?,
    val watchers: Int,
    val defaultBranch: String
) {
    constructor(api: ApiRepositoryDetails) : this(
        id = api.id,
        name = api.name,
        description = api.description,
        private = api.private,
        owner = api.owner.login,
        forks = api.forks,
        language = api.language,
        openIssues = api.openIssues,
        license = api.license?.name,
        watchers = api.watchers,
        defaultBranch = api.defaultBranch
    )
}
