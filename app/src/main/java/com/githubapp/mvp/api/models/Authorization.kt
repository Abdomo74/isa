package com.githubapp.mvp.api.models

import com.google.gson.annotations.SerializedName

data class Authorization(
        @SerializedName("id") var id: String,
        @SerializedName("token") var token: String){
    fun isAuthorized(): Boolean{
        return !id.isEmpty() || !token.isEmpty()
    }
}