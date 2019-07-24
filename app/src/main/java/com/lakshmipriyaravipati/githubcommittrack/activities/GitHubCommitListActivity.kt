package com.lakshmipriyaravipati.githubcommittrack.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.lakshmipriyaravipati.githubcommittrack.R
import com.lakshmipriyaravipati.githubcommittrack.databinding.ActivityGithubCommitListBinding
import com.lakshmipriyaravipati.githubcommittrack.viewmodels.GitHubCommitListViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class GitHubCommitListActivity : AppCompatActivity() {

    @Inject
    lateinit var gitHubCommitListViewModel: GitHubCommitListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        val binding = DataBindingUtil.setContentView<ActivityGithubCommitListBinding>(this, R.layout.activity_github_commit_list)
        binding.commitListViewModel = gitHubCommitListViewModel
    }
}
