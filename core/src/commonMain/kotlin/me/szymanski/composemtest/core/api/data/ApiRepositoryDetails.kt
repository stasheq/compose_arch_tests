package me.szymanski.composemtest.core.api.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiRepositoryDetails(
    val id: String,
    val name: String,
    val description: String?,
    val private: Boolean,
    val owner: ApiOwner,
    val forks: Int,
    val language: String?,
    @SerialName("open_issues_count")
    val openIssues: Int,
    val license: ApiLicense?,
    val watchers: Int,
    @SerialName("default_branch")
    val defaultBranch: String
)
