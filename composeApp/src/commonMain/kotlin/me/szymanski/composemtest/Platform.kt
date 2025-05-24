package me.szymanski.composemtest

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform