package com.githubapp.mvp.di.module

import com.githubapp.mvp.di.scope.ActivityScope
import com.githubapp.mvp.ui.login.ILoginPresenter
import com.githubapp.mvp.ui.login.LoginManager
import com.githubapp.mvp.ui.login.LoginPresenter
import dagger.Module
import dagger.Provides

@Module
class LoginModule {
    @Provides
    @ActivityScope
    fun provideLoginPresenter(loginManager: LoginManager): ILoginPresenter {
        return LoginPresenter(loginManager)
    }
}