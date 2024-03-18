package com.githubapp.mvp.data.source.remote

import com.githubapp.mvp.api.GithubApi
import com.githubapp.mvp.data.models.Repo
import com.githubapp.mvp.data.models.User
import com.githubapp.mvp.data.source.IDataSource
import com.githubapp.mvp.ui.login.LoginManager
import io.reactivex.Observable
import javax.inject.Inject

class RemoteDataSource : IDataSource{
    var api : GithubApi
    var loginManager : LoginManager

    @Inject
    constructor(api: GithubApi, loginManager: LoginManager){
        this.api = api
        this.loginManager = loginManager
    }

    override fun getRepos(page: Int, query: String, sort: String): Observable<List<Repo>> {
        return api.getRepos(page, query, sort, loginManager.token())
                .map { it -> it.items }
    }

    override fun getRepo(username: String, repoName: String): Observable<Repo> {
        return api.getRepo(username, repoName, loginManager.token())
    }

    override fun getUser(username: String): Observable<User> {
        return api.getUser(username, loginManager.token())
    }
}