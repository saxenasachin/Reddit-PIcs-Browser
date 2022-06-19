package com.saxenasachin.data.repositories

import com.saxenasachin.data.models.PullRequestEntity
import com.saxenasachin.data.models.SingleRepoEntity
import com.saxenasachin.data.models.request.PullRequestGetBody
import io.reactivex.Single

/**
Created by Sachin Saxena on 19/06/22.
 */
interface RedditRemote {
    fun getUserGitRepositories(username: String): Single<List<SingleRepoEntity>>

    fun getPullRequestList(pullRequestGetBody: PullRequestGetBody): Single<List<PullRequestEntity>>
}