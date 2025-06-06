package me.szymanski.composemtest.core.api

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import me.szymanski.composemtest.core.Config
import me.szymanski.composemtest.core.log as nativeLog

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
    install(Logging) {
        logger = object : Logger {
            override fun log(message: String) = nativeLog(message)
        }
        level = if (Config.Api.LOG_ENABLED) LogLevel.ALL else LogLevel.NONE
    }
    defaultRequest {
        url(Config.Api.HOST)
    }
}
