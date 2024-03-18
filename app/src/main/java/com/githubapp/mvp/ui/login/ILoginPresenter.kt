package com.githubapp.mvp.ui.login

import com.githubapp.mvp.ui.base.IBasePresenter
import com.githubapp.mvp.ui.login.ILoginView

interface ILoginPresenter : IBasePresenter<ILoginView> {
    fun login(email: String, password: String)
}