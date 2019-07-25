package com.lakshmipriyaravipati.githubcommittrack.viewmodels

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import com.lakshmipriyaravipati.githubcommittrack.adapter.GitHubCommitListAdapter
import com.lakshmipriyaravipati.githubcommittrack.service.CommitListProvider
import com.lakshmipriyaravipati.githubcommittrack.service.CommitListResponse
import javax.inject.Inject

class GitHubCommitListViewModel @Inject constructor(var itemsAdapter: GitHubCommitListAdapter,
                                                    private val commitListProvider : CommitListProvider) : ViewModel() {
    var isError = ObservableBoolean(false)

    private val commitItemList = mutableListOf<GitHubCommitListItemViewModel>()

     fun getCommitList() {
        commitListProvider.getCommitList("google","dagger")?.subscribe ({ it -> setItemAdapter(it) }, { it ->
            showError(it)
        })
    }

    private fun setItemAdapter(commitListResponse: List<CommitListResponse>) {
        commitListResponse.forEach {
            commitItemList.add(GitHubCommitListItemViewModel(it.commit?.author?.name, it.sha, it.commit?.message))
        }
        itemsAdapter.setViewModels(commitItemList)
    }

    private fun showError(error : Throwable) {
        isError.set(true)
    }
}