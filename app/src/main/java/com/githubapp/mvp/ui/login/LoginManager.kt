package com.githubapp.mvp.ui.login

import android.content.Context
import com.githubapp.mvp.api.GithubApi
import com.githubapp.mvp.api.models.Authorization
import com.githubapp.mvp.api.models.AuthorizationRequest
import com.githubapp.mvp.data.models.User
import io.reactivex.Observable
import okhttp3.Credentials
import javax.inject.Inject

class LoginManager{
    private var context: Context
    private var api: GithubApi
    private var preferences: LoginPreferences

    @Inject
    constructor(context: Context, api: GithubApi, preferences: LoginPreferences){
        this.context = context
        this.api = api
        this.preferences = preferences
    }

    fun login(email: String, password: String): Observable<Authorization>{
        return api.login(Credentials.basic(email, password), AuthorizationRequest(System.currentTimeMillis().toString()))
                  .doOnNext {
                      preferences.setID(it.id)
                      preferences.setToken(it.token)
                  }
    }

    fun logout(){
        preferences.removeID()
        preferences.removeToken()
    }

    fun isLogged(): Boolean{
        return preferences.getToken().isNotEmpty() &&
               preferences.getID().isNotEmpty()
    }

    fun token(): String{
        return preferences.getToken()
    }

    fun user(): Observable<User> {
        return api.getUserByToken(preferences.getToken())
    }
}