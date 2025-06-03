package me.szymanski.composemtest.core

actual fun log(message: String) {
    println(message) //TODO provice iOS implementation
}

actual fun logError(message: String, throwable: Throwable?) {
    println(message)
    throwable?.printStackTrace()
    //TODO provice iOS implementation
}
