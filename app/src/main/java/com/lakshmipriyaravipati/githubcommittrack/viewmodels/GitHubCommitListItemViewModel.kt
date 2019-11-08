package com.lakshmipriyaravipati.githubcommittrack.viewmodels

import androidx.lifecycle.ViewModel

class GitHubCommitListItemViewModel(val userName : String?, val commitHashValue: String?, val commitMessage: String?, val imageUrl : String?) : ViewModel()