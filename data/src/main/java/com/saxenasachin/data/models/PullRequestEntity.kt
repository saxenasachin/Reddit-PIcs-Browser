package com.saxenasachin.data.models

/**
Created by Sachin Saxena on 19/06/22.
 */
data class PullRequestEntity(
    val id: Int = -1,
    val desc: String = "",
    val title: String = "",
    val user: UserEntity = UserEntity(),
    val closedAt: String = "",
    val createdAt: String = ""
)