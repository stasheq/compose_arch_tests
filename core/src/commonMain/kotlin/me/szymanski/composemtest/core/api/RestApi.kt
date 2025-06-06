package me.szymanski.composemtest.core.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.http.appendPathSegments
import me.szymanski.composemtest.core.Config
import me.szymanski.composemtest.core.api.data.ApiError.HttpErrorResponse
import me.szymanski.composemtest.core.api.data.ApiError.UnknownError
import me.szymanski.composemtest.core.api.data.ApiRepository
import me.szymanski.composemtest.core.api.data.ApiRepositoryDetails

class RestApi(
    private val httpClient: HttpClient
) {

    suspend fun getRepositories(user: String, page: Int): List<ApiRepository> = request {
        get {
            url {
                appendPathSegments("users", user, "repos")
                parameters.append("per_page", "${Config.Api.PAGE_SIZE}")
                parameters.append("page", "$page")
            }
        }.body()
    }

    suspend fun getRepository(user: String, repoName: String): ApiRepositoryDetails = request {
        get { url { appendPathSegments("repos", user, repoName) } }.body()
    }

    private suspend inline fun <reified T> request(executeRequest: HttpClient.() -> HttpResponse): T = try {
        val response = httpClient.executeRequest()
        when {
            response.status.value in 200..299 -> response.body<T>()
            else -> throw HttpErrorResponse(
                RuntimeException("HTTP status: ${response.status.value}"),
                response.status.value
            )
        }

    } catch (t: Throwable) {
        throw UnknownError(t)
    }
}
