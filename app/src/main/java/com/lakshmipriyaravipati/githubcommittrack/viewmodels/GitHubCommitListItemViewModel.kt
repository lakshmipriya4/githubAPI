package com.lakshmipriyaravipati.githubcommittrack.viewmodels

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.annotation.DrawableRes
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide

class GitHubCommitListItemViewModel(val userName : String?, val commitHashValue: String?, val commitMessage: String?, val imageUrl : String?) : ViewModel() {


}