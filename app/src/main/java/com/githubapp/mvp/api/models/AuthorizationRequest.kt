package com.githubapp.mvp.api.models

import com.google.gson.annotations.SerializedName

data class AuthorizationRequest(@SerializedName("note") var note: String,
                                @SerializedName("scopes") var scopes: ArrayList<String> = arrayListOf("user"))