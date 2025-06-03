package me.szymanski.composemtest.core.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.appendPathSegments
import me.szymanski.composemtest.core.Config
import me.szymanski.composemtest.core.api.data.ApiRepository
import me.szymanski.composemtest.core.api.data.ApiRepositoryDetails

class RestApi(
    private val httpClient: HttpClient
) {

    suspend fun getRepositories(user: String, page: Int): List<ApiRepository> = httpClient.get {
        url {
            appendPathSegments("users", user, "repos")
            parameters.append("per_page", "${Config.Api.PAGE_SIZE}")
            parameters.append("page", "$page")
        }
    }.body()


    suspend fun getRepository(user: String, repoName: String): ApiRepositoryDetails = httpClient.get {
        url {
            appendPathSegments("repos", user, repoName)
        }
    }.body()
}
