package com.saxenasachin.presentation.views.views

data class SingleRepoView(
    val repoName: String = "",
    val repoDescription: String = "",
    val openIssuesCount: Int = -1,
    val forksCount: Int = -1,
    val defaultBranch: String = ""
)