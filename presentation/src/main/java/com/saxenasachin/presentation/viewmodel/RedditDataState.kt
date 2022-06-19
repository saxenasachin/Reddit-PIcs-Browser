package com.saxenasachin.presentation.viewmodel

import com.saxenasachin.presentation.views.views.PullRequestView
import com.saxenasachin.presentation.views.views.SingleRepoView

sealed class RedditDataState {

    object Init : RedditDataState()

    data class Loading(val message: String) : RedditDataState()

    data class Error(val message: String) : RedditDataState()

    data class GetUsersRepositoriesSuccess(
        val lisOfRepos: List<SingleRepoView>
    ) : RedditDataState()

    data class GetPullRequestsSuccess(
        val lisOfPullRequests: List<PullRequestView>
    ) : RedditDataState()
}