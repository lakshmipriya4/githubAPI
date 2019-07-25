package com.remindme.dagger

import com.lakshmipriyaravipati.githubcommittrack.GitHubCommitTrackApplication
import com.lakshmipriyaravipati.githubcommittrack.service.CommitListProvider
import com.remindme.dagger.modules.AndroidViewModule
import com.remindme.dagger.modules.AppModule
import dagger.Component
import dagger.android.AndroidInjectionModule

@Component(modules = [AppModule::class, AndroidInjectionModule::class, AndroidViewModule::class, CommitListProvider::class])
interface ApplicationComponent {

    fun inject(gitHubCommitTrackApplication: GitHubCommitTrackApplication)
}