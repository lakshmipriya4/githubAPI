package com.lakshmipriyaravipati.githubcommittrack.service

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class CommitModule {

    @Provides
    @Singleton
    fun providesCommitService(retrofit: Retrofit): CommitService {
        return retrofit.create(CommitService::class.java)
    }

    @Provides
    @Singleton
    fun providesCommitListProvider(commitService: CommitService): CommitListProvider {
        return CommitListProvider(commitService)
    }
}