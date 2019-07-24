package com.remindme.dagger.modules

import com.lakshmipriyaravipati.githubcommittrack.activities.GitHubCommitListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AndroidViewModule {

    @ContributesAndroidInjector
    abstract fun bindGitHubCommitListActivity(): GitHubCommitListActivity
}