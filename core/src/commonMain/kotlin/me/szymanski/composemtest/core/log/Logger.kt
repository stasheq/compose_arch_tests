package me.szymanski.composemtest.core.log

interface Logger {
    fun log(message: String)
    fun logError(message: String)
}

fun Logger.logError(message: String, e: Throwable) {
    logError(message)
    logError(e.stackTraceToString())
}
