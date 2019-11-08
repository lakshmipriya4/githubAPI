package com.lakshmipriyaravipati.githubcommittrack.dagger

import com.lakshmipriyaravipati.githubcommittrack.GitHubCommitTrackApplication
import com.lakshmipriyaravipati.githubcommittrack.dagger.modules.RetrofitClientModule
import com.lakshmipriyaravipati.githubcommittrack.service.CommitModule
import com.remindme.dagger.modules.AndroidViewModule
import com.lakshmipriyaravipati.githubcommittrack.dagger.modules.AppModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, AndroidInjectionModule::class, AndroidViewModule::class, RetrofitClientModule::class, CommitModule::class])
interface ApplicationComponent {

    fun inject(gitHubCommitTrackApplication: GitHubCommitTrackApplication)
}