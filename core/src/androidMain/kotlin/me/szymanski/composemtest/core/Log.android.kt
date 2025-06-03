package me.szymanski.composemtest.core

import android.util.Log

actual fun log(message: String) {
    Log.d(LOG_TAG, message)
}

actual fun logError(message: String, throwable: Throwable?) {
    Log.e(LOG_TAG, message, throwable)
}
