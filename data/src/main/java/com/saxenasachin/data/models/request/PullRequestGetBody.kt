package com.saxenasachin.data.models.request

/**
Created by Sachin Saxena on 19/06/22.
 */
data class PullRequestGetBody(
    val userName: String,
    val repositoryName: String,
    val state: String
)