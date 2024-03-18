package com.githubapp.mvp.ui.splash

import com.githubapp.mvp.ui.base.IBaseView

interface ISplashView : IBaseView {
    fun navigateToLogin()
    fun navigateToMain()
}