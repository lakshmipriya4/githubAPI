package com.lakshmipriyaravipati.githubcommittrack.service

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface CommitService {

    @GET("{projectName}/commits") //Hello-World/commits
    fun getCommits(@Path("projectName") projectName:String) : Single<List<CommitListResponse>>
}