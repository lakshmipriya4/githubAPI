package com.lakshmipriyaravipati.githubcommittrack.service

data class CommitListResponse(
    val sha: String,
    val CommitObject: Commit,
    val AuthorObject: Author
)