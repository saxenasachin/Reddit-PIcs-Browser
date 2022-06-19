package com.saxenasachin.presentation.viewmodel

import com.saxenasachin.presentation.views.views.RedditPicView

sealed class RedditDataState {

    object Init : RedditDataState()

    data class Loading(val message: String) : RedditDataState()

    data class Error(val message: String) : RedditDataState()

    data class GetRedditPicsSuccess(
        val data: RedditPicView
    ) : RedditDataState()
}