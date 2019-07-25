package com.lakshmipriyaravipati.githubcommittrack.service

import com.lakshmipriyaravipati.githubcommittrack.dagger.modules.RetrofitClientModule
import dagger.Module
import dagger.Provides
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

@Module
class CommitListProvider {

    var retrofitClientModule = RetrofitClientModule()

    @Provides
    @Singleton
    fun provideCommitListService(projectName : String): Single<List<CommitListResponse>>? {
        return retrofitClientModule.retrofitInstace()
            .create(CommitService::class.java)
            .getCommits(projectName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}