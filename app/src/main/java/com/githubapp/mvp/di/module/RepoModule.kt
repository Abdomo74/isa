package com.githubapp.mvp.di.module

import com.githubapp.mvp.data.source.DataSource
import com.githubapp.mvp.di.scope.ActivityScope
import com.githubapp.mvp.ui.repository.IRepoPresenter
import com.githubapp.mvp.ui.repository.RepoPresenter
import dagger.Module
import dagger.Provides

@Module
class RepoModule {
    @Provides
    @ActivityScope
    fun provideRepoPresenter(dataSource: DataSource): IRepoPresenter{
        return RepoPresenter(dataSource)
    }
}