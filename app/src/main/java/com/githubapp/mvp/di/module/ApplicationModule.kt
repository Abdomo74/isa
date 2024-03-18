package com.githubapp.mvp.di.module

import android.app.Application
import android.content.Context
import android.preference.PreferenceManager
import com.githubapp.mvp.api.GithubApi
import com.githubapp.mvp.data.source.DataSource
import com.githubapp.mvp.data.source.remote.RemoteDataSource
import com.githubapp.mvp.ui.login.LoginManager
import com.githubapp.mvp.ui.login.LoginPreferences
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApplicationModule() {
    @Provides
    @Singleton
    fun provideContext(application: Application): Context{
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun provideGithubRetrofit(): Retrofit{
        return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(GithubApi.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    @Provides
    @Singleton
    fun provideGithubService(retrofit: Retrofit): GithubApi{
        return retrofit.create(GithubApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource(githubService: GithubApi, loginManager: LoginManager): RemoteDataSource {
        return RemoteDataSource(githubService, loginManager)
    }

    @Provides
    @Singleton
    fun provideDataSource(remoteDataSource: RemoteDataSource): DataSource{
        return DataSource(remoteDataSource)
    }


    @Provides
    @Singleton
    fun provideLoginPreferences(context: Context): LoginPreferences{
        return LoginPreferences(PreferenceManager.getDefaultSharedPreferences(context))
    }

    @Provides
    @Singleton
    fun provideLoginManager(context: Context, api: GithubApi, preferences: LoginPreferences): LoginManager {
        return LoginManager(context, api, preferences)
    }
}