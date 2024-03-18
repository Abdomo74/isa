package com.githubapp.mvp.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
        @SerializedName("login") val username: String,
        @SerializedName("avatar_url") val image: String,
        @SerializedName("html_url") val url: String,
        @SerializedName("type") val type: String,
        @SerializedName("id") val id: String,
        @SerializedName("name") val name: String,
        @SerializedName("company") val company: String,
        @SerializedName("location") val location: String,
        @SerializedName("email") val email: String,
        @SerializedName("bio") val bio: String,
        @SerializedName("followers") val followers: Int,
        @SerializedName("following") val following: Int): Parcelable