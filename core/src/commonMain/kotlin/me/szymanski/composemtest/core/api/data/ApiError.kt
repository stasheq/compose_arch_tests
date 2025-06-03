package me.szymanski.composemtest.core.api.data

sealed class ApiError(cause: Throwable? = null) : Throwable(cause) {
    class HttpErrorResponse(cause: Throwable, val code: Int) : ApiError(cause)
    class NoConnection(cause: Throwable) : ApiError(cause)
    class UnknownError(cause: Throwable) : ApiError(cause)
}
