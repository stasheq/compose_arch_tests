package me.szymanski.composemtest.core.api

data class ApiRepository(
    val id: String,
    val name: String,
    val description: String?,
    val owner: ApiOwner,
)
