package com.githubapp.mvp.ui.login

import android.content.SharedPreferences
import javax.inject.Inject

class LoginPreferences{
    companion object {
        const val ID: String = "ID"
        const val TOKEN: String = "TOKEN"
    }

    private var preferences: SharedPreferences

    @Inject
    constructor(preferences: SharedPreferences){
        this.preferences = preferences
    }

    fun getID(): String {
        return preferences.getString(ID, "")!!
    }

    fun getToken(): String {
        return preferences.getString(TOKEN, "")!!
    }

    fun setID(id: String){
        preferences
                .edit()
                .putString(ID, id)
                .apply()
    }

    fun setToken(token: String){
        preferences
                .edit()
                .putString(TOKEN, token)
                .apply()
    }

    fun removeID(){
        preferences
                .edit()
                .remove(ID)
                .apply()
    }

    fun removeToken(){
        preferences
                .edit()
                .remove(TOKEN)
                .apply()
    }
}