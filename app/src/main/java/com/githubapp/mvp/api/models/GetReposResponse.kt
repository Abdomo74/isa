package com.githubapp.mvp.api.models

import com.githubapp.mvp.data.models.Repo
import com.google.gson.annotations.SerializedName

data class GetReposResponse(
        @SerializedName("total_count") val count: String,
        @SerializedName("items") val items: List<Repo>)