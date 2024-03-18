package com.githubapp.mvp.ui.repository

import com.githubapp.mvp.data.models.Repo
import com.githubapp.mvp.data.models.User
import com.githubapp.mvp.ui.base.IBaseView

interface IRepoView : IBaseView {
    fun loadRepo(repo: Repo)
}