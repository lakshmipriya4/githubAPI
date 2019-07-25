package com.lakshmipriyaravipati.githubcommittrack.service

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface CommitService {

    @GET("{repoName}/{projectName}/commits")
    fun getCommits(@Path("repoName") repoName: String, @Path("projectName") projectName: String): Single<List<CommitListResponse>>
}