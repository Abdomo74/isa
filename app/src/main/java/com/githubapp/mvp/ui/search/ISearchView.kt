package com.githubapp.mvp.ui.search

import com.githubapp.mvp.data.models.Repo
import com.githubapp.mvp.ui.base.IBaseView

interface ISearchView : IBaseView {
        fun clearRepos()
    fun addRepos(repos: List<Repo>)
    fun navigateToProfile()
    fun navigateToUser(username: String)
    fun navigateToRepo(username: String, repoName: String)
}