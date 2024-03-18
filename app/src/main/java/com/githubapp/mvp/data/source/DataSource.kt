package com.githubapp.mvp.data.source

import com.githubapp.mvp.data.models.Repo
import com.githubapp.mvp.data.models.User
import com.githubapp.mvp.data.source.remote.RemoteDataSource
import io.reactivex.Observable
import javax.inject.Inject

class DataSource : IDataSource{
    var remoteDataSource: RemoteDataSource

    @Inject
    constructor(remoteDataSource: RemoteDataSource){
        this.remoteDataSource = remoteDataSource
    }

    override fun getRepos(page: Int, query: String, sort: String): Observable<List<Repo>> {
        return remoteDataSource.getRepos(page, query, sort)
    }

    override fun getRepo(username: String, repoName: String): Observable<Repo> {
        return remoteDataSource.getRepo(username, repoName)
    }

    override fun getUser(username: String): Observable<User> {
        return remoteDataSource.getUser(username)
    }
}