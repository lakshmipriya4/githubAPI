package com.lakshmipriyaravipati.githubcommittrack

import android.app.Activity
import android.app.Application
import android.content.Context
import com.remindme.dagger.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class GitHubCommitTrackApplication : Application(), HasActivityInjector {

    @set:Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()
        DaggerApplicationComponent.builder().build().inject(this)
    }
}