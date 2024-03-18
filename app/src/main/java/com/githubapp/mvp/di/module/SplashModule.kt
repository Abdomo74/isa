package com.githubapp.mvp.di.module

import com.githubapp.mvp.di.scope.ActivityScope
import com.githubapp.mvp.ui.login.LoginManager
import com.githubapp.mvp.ui.splash.ISplashPresenter
import com.githubapp.mvp.ui.splash.SplashPresenter
import dagger.Module
import dagger.Provides

@Module
class SplashModule {
    @Provides
    @ActivityScope
    fun provideSplashPresenter(loginManager: LoginManager): ISplashPresenter{
        return SplashPresenter(loginManager)
    }
}