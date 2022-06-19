package com.saxenasachin.remote

import com.saxenasachin.data.models.PullRequestEntity
import com.saxenasachin.data.models.SingleRepoEntity
import com.saxenasachin.data.models.redditpics.RedditPicEntity
import com.saxenasachin.data.models.request.PullRequestGetBody
import com.saxenasachin.data.repositories.RedditRemote
import com.saxenasachin.remote.mappers.reddit.piclist.RedditPicsEntityMapper
import com.saxenasachin.remote.mappers.reddit.pull_request.PullRequestEntityMapper
import com.saxenasachin.remote.mappers.reddit.repos.SingleRepoEntityMapper
import com.saxenasachin.remote.services.github.RedditService
import io.reactivex.Single
import javax.inject.Inject

class RedditRemoteRepositoryImp @Inject constructor(
    private val redditService: RedditService,
    private val pullRequestEntityMapper: PullRequestEntityMapper,
    private val singleRepoEntityMapper: SingleRepoEntityMapper,
    private val redditPicsEntityMapper: RedditPicsEntityMapper
) : RedditRemote {

    override fun getUserGitRepositories(username: String): Single<List<SingleRepoEntity>> {
        return redditService.getUserRepositories(username)
            .map { listOfPRRemoteModels ->
                listOfPRRemoteModels.map { singleRepoEntityMapper.mapFromModel(it) }
            }
    }

    override fun getPullRequestList(pullRequestGetBody: PullRequestGetBody): Single<List<PullRequestEntity>> {
        return redditService.getPullRequestForGithubRepo(
            pullRequestGetBody.userName,
            pullRequestGetBody.repositoryName,
            pullRequestGetBody.state
        )
            .map { listOfRemoteRepos ->
                listOfRemoteRepos.map { pullRequestEntityMapper.mapFromModel(it) }
            }
    }

    override fun getRedditPics(): Single<RedditPicEntity> {
        return redditService.getRedditPics()
            .map {
                redditPicsEntityMapper.mapFromModel(it)
            }
    }
}