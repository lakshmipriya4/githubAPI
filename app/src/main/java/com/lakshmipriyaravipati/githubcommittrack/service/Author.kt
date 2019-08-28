package com.lakshmipriyaravipati.githubcommittrack.service

import com.google.gson.annotations.SerializedName

data class Author(
    @SerializedName("avatar_url")
    val avatarUrl: String
)