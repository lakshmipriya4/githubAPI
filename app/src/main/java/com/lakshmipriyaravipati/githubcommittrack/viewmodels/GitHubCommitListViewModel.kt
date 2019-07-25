package com.lakshmipriyaravipati.githubcommittrack.viewmodels

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import com.lakshmipriyaravipati.githubcommittrack.adapter.GitHubCommitListAdapter
import com.lakshmipriyaravipati.githubcommittrack.service.CommitListProvider
import com.lakshmipriyaravipati.githubcommittrack.service.CommitListResponse
import javax.inject.Inject

class GitHubCommitListViewModel @Inject constructor(var itemsAdapter: GitHubCommitListAdapter) : ViewModel() {

    var commitListProvider = CommitListProvider()
    val commitItemList = mutableListOf<GitHubCommitListItemViewModel>()

     fun getCommitList() {
        commitListProvider.provideCommitListService("google","dagger")?.subscribe ({ it -> setItemAdapter(it) }, {
            error(
                print("errorrrr")
            )
        })
    }

    fun setItemAdapter(commitListResponse: List<CommitListResponse>) {
        commitListResponse.forEach {
            commitItemList.add(GitHubCommitListItemViewModel(it.commit?.author?.name, it.sha, it.commit?.message))
        }
        itemsAdapter.setViewModels(commitItemList)
    }
}