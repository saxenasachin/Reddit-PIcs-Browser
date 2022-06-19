package com.saxenasachin.domain.models.pullrequest

import com.saxenasachin.domain.models.user.User

/**
Created by Sachin Saxena on 19/06/22.
 */
data class PullRequest(
    val id: Int = -1,
    val desc: String = "",
    val title: String = "",
    val user: User = User(),
    val closedAt: String = "",
    val createdAt: String = ""
) {
    enum class State {
        OPEN, CLOSED, ALL
    }
}