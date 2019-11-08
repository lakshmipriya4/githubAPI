package com.lakshmipriyaravipati.githubcommittrack.service

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CommitListProvider @Inject constructor(private val commitService: CommitService) {

    fun getCommitList(repoName: String, projectName: String): Single<List<CommitListResponse>>? {
        return commitService
            .getCommits(repoName, projectName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}