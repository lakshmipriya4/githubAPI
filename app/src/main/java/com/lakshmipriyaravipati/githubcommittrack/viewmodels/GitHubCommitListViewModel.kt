package com.lakshmipriyaravipati.githubcommittrack.viewmodels

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import com.lakshmipriyaravipati.githubcommittrack.adapter.GitHubCommitListAdapter
import com.lakshmipriyaravipati.githubcommittrack.service.CommitListProvider
import com.lakshmipriyaravipati.githubcommittrack.service.CommitListResponse
import javax.inject.Inject

class GitHubCommitListViewModel @Inject constructor(
    var itemsAdapter: GitHubCommitListAdapter,
    private val commitListProvider: CommitListProvider
) : ViewModel(), LifecycleObserver {
    var isError = ObservableBoolean(false)

    private val commitItemList = mutableListOf<GitHubCommitListItemViewModel>()

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun getCommitList() {
        commitListProvider.getCommitList("google", "dagger")?.subscribe({ it -> setItemAdapter(it) }, { it ->
            showError()
        })
    }

    private fun setItemAdapter(commitListResponse: List<CommitListResponse>) {
        commitListResponse.forEach {

            commitItemList.add(
                GitHubCommitListItemViewModel(
                    it.commit?.author?.name,
                    it.sha,
                    it.commit?.message,
                    it.author?.avatarUrl
                )
            )
        }
        itemsAdapter.setViewModels(commitItemList)
    }

    private fun showError() {
        isError.set(true)
    }
}