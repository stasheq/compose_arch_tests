package me.szymanski.composemtest.core.api

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import me.szymanski.composemtest.core.Config

fun createHttpClient() = HttpClient {
    install(HttpTimeout) {
        requestTimeoutMillis = Config.Api.TIMEOUT_MS
    }
    install(ContentNegotiation) {
        json(Json {
            encodeDefaults = true
            isLenient = true
            coerceInputValues = true
            ignoreUnknownKeys = true
        })
    }
    defaultRequest {
        host = Config.Api.HOST
        port = Config.Api.PORT
    }
}
