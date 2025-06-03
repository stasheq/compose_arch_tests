package me.szymanski.composemtest.core.api.data

import kotlinx.serialization.Serializable

@Serializable
data class ApiOwner(
    val login: String
)
