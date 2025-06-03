package me.szymanski.composemtest.core.api.data

import kotlinx.serialization.Serializable

@Serializable
data class ApiRepository(
    val id: String,
    val name: String,
    val description: String?,
    val owner: ApiOwner,
)
