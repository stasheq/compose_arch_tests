package me.szymanski.composemtest.core

object Config {
    const val INITIAL_USER = "google"

    object Api {
        const val HOST = "https://api.github.com/"
        const val PAGE_SIZE = 20
        const val TIMEOUT_MS = 5000L
        const val LOG_ENABLED = true
    }
}
