package com.githubapp.mvp.ui.repository

import com.githubapp.mvp.ui.base.IBasePresenter

interface IRepoPresenter : IBasePresenter<IRepoView> {
    fun getRepo(username: String, repoName: String)
}