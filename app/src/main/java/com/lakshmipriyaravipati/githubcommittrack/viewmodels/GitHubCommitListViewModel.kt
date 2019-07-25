package com.lakshmipriyaravipati.githubcommittrack.viewmodels

import androidx.lifecycle.ViewModel
import com.lakshmipriyaravipati.githubcommittrack.adapter.GitHubCommitListAdapter
import com.lakshmipriyaravipati.githubcommittrack.service.CommitListProvider
import com.lakshmipriyaravipati.githubcommittrack.service.CommitListResponse
import javax.inject.Inject

class GitHubCommitListViewModel @Inject constructor(var itemsAdapter: GitHubCommitListAdapter) : ViewModel() {

    var commitListProvider = CommitListProvider()
    val list = mutableListOf(GitHubCommitListItemViewModel("userName", "commit", "commit"),
        GitHubCommitListItemViewModel("userName", "commit", "commit"),
        GitHubCommitListItemViewModel("userName", "commit", "commit"))

    init {
        itemsAdapter.setViewModels(list)
//        commitListProvider.provideCommitListService("GitHubCommitTrack")?.subscribe ({ it -> setItemAdapter(it) }, {
//            error(
//                print("errorrrr")
//            )
//        })
    }

    fun setItemAdapter(commitListResponse: List<CommitListResponse>) {
        commitListResponse.forEach {
            list.add(GitHubCommitListItemViewModel(it.AuthorObject?.name, it.sha, it.CommitObject?.message))
        }
        itemsAdapter.setViewModels(list)
    }
}