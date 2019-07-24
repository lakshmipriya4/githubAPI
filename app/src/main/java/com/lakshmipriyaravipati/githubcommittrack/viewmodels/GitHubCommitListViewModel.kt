package com.lakshmipriyaravipati.githubcommittrack.viewmodels

import androidx.lifecycle.ViewModel
import com.lakshmipriyaravipati.githubcommittrack.adapter.GitHubCommitListAdapter
import javax.inject.Inject

class GitHubCommitListViewModel @Inject constructor(var itemsAdapter : GitHubCommitListAdapter): ViewModel() {

    val list = mutableListOf(GitHubCommitListItemViewModel("userName","commit","commit"))

    init {
        itemsAdapter.setViewModels( list)
    }
}