package com.githubapp.mvp.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Repo(
        @SerializedName("id") val id: String,
        @SerializedName("name") val name: String,
        @SerializedName("description") val description: String,
        @SerializedName("html_url") val url: String,
        @SerializedName("watchers_count") val watchers: Int,
        @SerializedName("forks_count") val forks: Int,
        @SerializedName("open_issues_count") val issues: Int,
        @SerializedName("owner") val user: User,
        @SerializedName("created_at") val date: Date) : Parcelable