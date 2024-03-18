package com.githubapp.mvp.ui.splash

import com.githubapp.mvp.ui.base.IBasePresenter

interface ISplashPresenter : IBasePresenter<ISplashView> {
    fun checkLogin()
}