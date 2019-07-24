package com.remindme.dagger

import com.lakshmipriyaravipati.githubcommittrack.GitHubCommitTrackApplication
import com.lakshmipriyaravipati.githubcommittrack.dagger.modules.RetrofitClientModule
import com.remindme.dagger.modules.AndroidViewModule
import com.remindme.dagger.modules.AppModule
import dagger.Component
import dagger.android.AndroidInjectionModule

@Component(modules = [AppModule::class, AndroidInjectionModule::class, AndroidViewModule::class, RetrofitClientModule::class])
interface ApplicationComponent {

    fun inject(gitHubCommitTrackApplication: GitHubCommitTrackApplication)
}