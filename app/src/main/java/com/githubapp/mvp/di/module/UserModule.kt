package com.githubapp.mvp.di.module

import com.githubapp.mvp.data.source.DataSource
import com.githubapp.mvp.di.scope.ActivityScope
import com.githubapp.mvp.ui.splash.SplashPresenter
import com.githubapp.mvp.ui.user.IUserPresenter
import com.githubapp.mvp.ui.user.UserPresenter
import dagger.Module
import dagger.Provides

@Module
class UserModule {
    @Provides
    @ActivityScope
    fun provideUserPresenter(dataSource: DataSource): IUserPresenter {
        return UserPresenter(dataSource)
    }
}