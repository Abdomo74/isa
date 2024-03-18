package com.githubapp.mvp.ui.login

import com.githubapp.mvp.ui.base.IBaseView

interface ILoginView : IBaseView {
    fun loginSucceeded()
    fun loginFailed()
}