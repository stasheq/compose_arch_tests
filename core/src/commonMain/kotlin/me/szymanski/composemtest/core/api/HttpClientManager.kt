package me.szymanski.composemtest.core.api

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import me.szymanski.composemtest.core.Config
import me.szymanski.composemtest.core.log.Logger
import io.ktor.client.plugins.logging.Logger as KtorLogger

fun createHttpClient(
    appLogger: Logger
) = HttpClient {
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
        logger = object : KtorLogger {
            override fun log(message: String) = appLogger.log(message)
        }
        level = if (Config.Api.LOG_ENABLED) LogLevel.ALL else LogLevel.NONE
    }
    defaultRequest {
        url(Config.Api.HOST)
    }
}
