package com.lakshmipriyaravipati.githubcommittrack.service

import com.lakshmipriyaravipati.githubcommittrack.dagger.modules.RetrofitClientModule
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CommitListProvider @Inject constructor() {

    var retrofitClientModule = RetrofitClientModule()

    fun getCommitList(repoName: String, projectName: String): Single<List<CommitListResponse>>? {
        return retrofitClientModule.providesCommitService()
            .getCommits(repoName, projectName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}