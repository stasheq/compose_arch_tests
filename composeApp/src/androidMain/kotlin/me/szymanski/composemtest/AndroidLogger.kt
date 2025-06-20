package me.szymanski.composemtest

import android.util.Log
import me.szymanski.composemtest.core.log.Logger

class AndroidLogger : Logger {
    private val tag = "compose_m_tests"

    override fun log(message: String) {
        Log.d(tag, message)
    }

    override fun logError(message: String) {
        Log.e(tag, message)
    }
}
