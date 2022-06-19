package com.saxenasachin.data.repositories

import com.saxenasachin.data.models.PullRequestEntity
import com.saxenasachin.data.models.SingleRepoEntity
import io.reactivex.Single

/**
Created by Sachin Saxena on 19/06/22.
 */
interface RedditDataStore {
    fun getUserGitRepositories(username: String): Single<List<SingleRepoEntity>>

    fun getPullRequestList(
        username: String,
        repoName: String,
        state: String
    ): Single<List<PullRequestEntity>>
}