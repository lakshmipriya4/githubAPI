package com.lakshmipriyaravipati.githubcommittrack.viewmodels

import androidx.recyclerview.widget.RecyclerView
import com.lakshmipriyaravipati.githubcommittrack.databinding.ItemGithubCommitBinding

class GitHubCommitListItemViewHolder(val binding: ItemGithubCommitBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(commitListItemViewModel: GitHubCommitListItemViewModel) {
        binding.commitListItemViewModel = commitListItemViewModel
        binding.executePendingBindings()
    }
}