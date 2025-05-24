package me.szymanski.composemtest

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText

class Greeting {
    private val platform = getPlatform()
    private val client = HttpClient()

    suspend fun greeting(): String {
        val response = client.get("https://ktor.io/docs/")
        return platform.name + "\n" + response.bodyAsText()
    }
}
