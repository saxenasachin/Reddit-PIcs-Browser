package com.saxenasachin.data.store

import com.saxenasachin.data.models.PullRequestEntity
import com.saxenasachin.data.models.SingleRepoEntity
import com.saxenasachin.data.models.request.PullRequestGetBody
import com.saxenasachin.data.repositories.RedditDataStore
import com.saxenasachin.data.repositories.RedditRemote
import io.reactivex.Single
import javax.inject.Inject

/**
Created by Sachin Saxena on 19/06/22.
 */
class RedditRemoteDataStore @Inject constructor(
    private val redditRemote: RedditRemote
) : RedditDataStore {


    override fun getUserGitRepositories(username: String): Single<List<SingleRepoEntity>> {
        return redditRemote.getUserGitRepositories(username)
    }

    override fun getPullRequestList(
        username: String,
        repoName: String,
        state: String
    ): Single<List<PullRequestEntity>> {
        return redditRemote.getPullRequestList(PullRequestGetBody(username, repoName, state))
    }
}