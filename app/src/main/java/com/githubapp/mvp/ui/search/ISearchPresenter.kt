package com.githubapp.mvp.ui.search

import com.githubapp.mvp.data.models.User
import com.githubapp.mvp.data.models.Repo
import com.githubapp.mvp.ui.base.IBasePresenter

interface ISearchPresenter : IBasePresenter<ISearchView> {
    fun loadRepos(page: Int = 0, query: String = "a", sort: Int = 0, clear: Boolean = false)
    fun onProfileClick()
    fun onRepoClick(repo: Repo)
    fun onUserClick(user: User)
}