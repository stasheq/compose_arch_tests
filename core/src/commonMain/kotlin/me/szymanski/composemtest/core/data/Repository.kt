package me.szymanski.composemtest.core.data

import me.szymanski.composemtest.core.api.ApiRepository

data class Repository(
    val id: String,
    val name: String,
    val description: String?,
    val owner: String,
) {
    constructor(api: ApiRepository) : this(
        id = api.id,
        name = api.name,
        description = api.description,
        owner = api.owner.login
    )
}
