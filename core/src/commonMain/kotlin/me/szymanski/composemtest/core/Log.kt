package me.szymanski.composemtest.core

const val LOG_TAG = "composemtest"

expect fun log(message: String)

expect fun logError(message: String, throwable: Throwable? = null)
