package com.githubapp.mvp.di.module

import com.githubapp.mvp.data.source.DataSource
import com.githubapp.mvp.di.scope.ActivityScope
import com.githubapp.mvp.ui.search.ISearchPresenter
import com.githubapp.mvp.ui.search.SearchPresenter
import com.githubapp.mvp.ui.search.adapters.RepoAdapter
import dagger.Module
import dagger.Provides

@Module
class SearchModule {
    @Provides
    @ActivityScope
    fun provideSearchPresenter(dataSource: DataSource): ISearchPresenter{
        return SearchPresenter(dataSource)
    }

    @Provides
    @ActivityScope
    fun provideRepoAdapter(): RepoAdapter{
        return RepoAdapter()
    }
}