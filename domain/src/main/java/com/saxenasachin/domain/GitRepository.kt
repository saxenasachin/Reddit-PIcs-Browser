package com.saxenasachin.domain

import com.saxenasachin.domain.models.pullrequest.PullRequest
import com.saxenasachin.domain.models.repo.GitSingleRepo
import io.reactivex.Single

/**
Created by Sachin Saxena on 19/06/22.
 */
interface GitRepository {

    fun getUserGitRepositories(username: String): Single<List<GitSingleRepo>>

    fun getPullRequestList(
        username: String,
        repoName: String,
        state: PullRequest.State = PullRequest.State.ALL
    ): Single<List<PullRequest>>
}