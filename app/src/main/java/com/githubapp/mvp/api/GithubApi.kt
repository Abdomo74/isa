package com.githubapp.mvp.api

import com.githubapp.mvp.api.models.Authorization
import com.githubapp.mvp.api.models.AuthorizationRequest
import com.githubapp.mvp.api.models.GetReposResponse
import com.githubapp.mvp.data.models.Repo
import com.githubapp.mvp.data.models.User
import io.reactivex.Observable
import retrofit2.http.*

interface GithubApi {
    companion object {
        const val API_URL = "https://api.github.com/"
    }

    @POST("authorizations")
    fun login(@Header("Authorization") authorization: String,
              @Body request: AuthorizationRequest): Observable<Authorization>

    @GET("user")
    fun getUserByToken(@Query("access_token") token: String): Observable<User>

    @GET("search/repositories")
    fun getRepos(
            @Query("page") page: Int,
            @Query("q") query: String,
            @Query("sort") sort: String,
            @Query("access_token") token: String,
            @Query("per_page") perPage: Int = 30): Observable<GetReposResponse>

    @GET("repos/{user}/{repo}")
    fun getRepo(@Path("user")username: String,
                @Path("repo")repoName: String,
                @Query("access_token") token: String): Observable<Repo>

    @GET("users/{username}")
    fun getUser(@Path("username")username: String,
                @Query("access_token") token: String): Observable<User>



}