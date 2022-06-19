package com.saxenasachin.remote

import com.saxenasachin.data.models.PullRequestEntity
import com.saxenasachin.data.models.SingleRepoEntity
import com.saxenasachin.data.models.request.PullRequestGetBody
import com.saxenasachin.data.repositories.RedditRemote
import com.saxenasachin.remote.mappers.reddit.pull_request.PullRequestEntityMapper
import com.saxenasachin.remote.mappers.reddit.repos.SingleRepoEntityMapper
import com.saxenasachin.remote.services.github.RedditService
import io.reactivex.Single
import javax.inject.Inject

class RedditRemoteRepositoryImp @Inject constructor(
    private val githubService: RedditService,
    private val pullRequestEntityMapper: PullRequestEntityMapper,
    private val singleRepoEntityMapper: SingleRepoEntityMapper
) : RedditRemote {

    override fun getUserGitRepositories(username: String): Single<List<SingleRepoEntity>> {
        return githubService.getUserRepositories(username)
            .map { listOfPRRemoteModels ->
                listOfPRRemoteModels.map { singleRepoEntityMapper.mapFromModel(it) }
            }
    }

    override fun getPullRequestList(pullRequestGetBody: PullRequestGetBody): Single<List<PullRequestEntity>> {
        return githubService.getPullRequestForGithubRepo(
            pullRequestGetBody.userName,
            pullRequestGetBody.repositoryName,
            pullRequestGetBody.state
        )
            .map { listOfRemoteRepos ->
                listOfRemoteRepos.map { pullRequestEntityMapper.mapFromModel(it) }
            }
    }
}