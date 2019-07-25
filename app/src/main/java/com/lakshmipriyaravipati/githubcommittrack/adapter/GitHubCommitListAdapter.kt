package com.lakshmipriyaravipati.githubcommittrack.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.lakshmipriyaravipati.githubcommittrack.R
import com.lakshmipriyaravipati.githubcommittrack.databinding.ItemGithubCommitBinding
import com.lakshmipriyaravipati.githubcommittrack.viewmodels.GitHubCommitListItemViewHolder
import com.lakshmipriyaravipati.githubcommittrack.viewmodels.GitHubCommitListItemViewModel
import javax.inject.Inject

class GitHubCommitListAdapter @Inject constructor() : RecyclerView.Adapter<GitHubCommitListItemViewHolder>() {

    private var commitListItemViewModel = mutableListOf<GitHubCommitListItemViewModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitHubCommitListItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ItemGithubCommitBinding>(
                layoutInflater,
                R.layout.item_github_commit,
                parent,
                false
            )
        return GitHubCommitListItemViewHolder(binding)
    }

    override fun getItemCount() = commitListItemViewModel.size

    override fun onBindViewHolder(holder: GitHubCommitListItemViewHolder, position: Int) {
        holder.bind(commitListItemViewModel[position])
    }

    fun setViewModels(commitListItemViewModel: MutableList<GitHubCommitListItemViewModel>) {
        this.commitListItemViewModel = commitListItemViewModel
        notifyDataSetChanged()
    }
}