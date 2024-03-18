package com.githubapp.mvp.di.module

import com.githubapp.mvp.di.scope.ActivityScope
import com.githubapp.mvp.ui.login.LoginManager
import com.githubapp.mvp.ui.profile.IProfilePresenter
import com.githubapp.mvp.ui.profile.ProfilePresenter
import dagger.Module
import dagger.Provides

@Module
class ProfileModule {
    @Provides
    @ActivityScope
    fun provideProfilePresenter(loginManager: LoginManager): IProfilePresenter{
        return ProfilePresenter(loginManager)
    }
}