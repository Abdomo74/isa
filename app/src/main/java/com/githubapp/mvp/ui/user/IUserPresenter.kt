package com.githubapp.mvp.ui.user

import com.githubapp.mvp.ui.base.IBasePresenter

interface IUserPresenter : IBasePresenter<IUserView> {
    fun getUser(username: String)
}