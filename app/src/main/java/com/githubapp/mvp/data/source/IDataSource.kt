package com.githubapp.mvp.data.source

import com.githubapp.mvp.data.models.Repo
import com.githubapp.mvp.data.models.User
import io.reactivex.Observable

interface IDataSource {
    fun getRepos(page: Int, query: String, sort: String): Observable<List<Repo>>
    fun getRepo(username: String, repoName: String): Observable<Repo>
    fun getUser(username: String): Observable<User>
}