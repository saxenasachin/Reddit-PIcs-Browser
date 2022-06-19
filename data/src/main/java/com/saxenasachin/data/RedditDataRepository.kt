package com.saxenasachin.data

import com.saxenasachin.data.mapper.piclist.PicModelMapper
import com.saxenasachin.data.mapper.pull_request.PullRequestMapper
import com.saxenasachin.data.mapper.single_repo.SingleRepoMapper
import com.saxenasachin.data.store.RedditDataStoreFactory
import com.saxenasachin.domain.RedditRepository
import com.saxenasachin.domain.models.piclist.RedditPicModel
import com.saxenasachin.domain.models.pullrequest.PullRequest
import com.saxenasachin.domain.models.repo.GitSingleRepo
import io.reactivex.Single
import javax.inject.Inject

/**
Created by Sachin Saxena on 19/06/22.
 */
class RedditDataRepository @Inject constructor(
    private val pullRequestMapper: PullRequestMapper,
    private val singleRepoMapper: SingleRepoMapper,
    private val picModelMapper: PicModelMapper,
    private val redditDataStoreFactory: RedditDataStoreFactory
) : RedditRepository {

    override fun getUserGitRepositories(username: String): Single<List<GitSingleRepo>> {
        return redditDataStoreFactory.getRemoteDataStore()
            .getUserGitRepositories(username).map { listOfGitSingleRepos ->
                listOfGitSingleRepos.map { singleRepoMapper.mapFromEntity(it) }
            }
    }

    override fun getPullRequestList(
        username: String,
        repoName: String,
        state: PullRequest.State
    ): Single<List<PullRequest>> {
        return redditDataStoreFactory.getRemoteDataStore()
            .getPullRequestList(username, repoName, getPullRequestState(state))
            .map { listOfPullRequest ->
                listOfPullRequest.map { pullRequestMapper.mapFromEntity(it) }
            }
    }

    override fun getRedditPics(): Single<RedditPicModel> {
        return redditDataStoreFactory.getRemoteDataStore()
            .getRedditPics()
            .map {
                picModelMapper.mapFromEntity(it)
            }
    }

    private fun getPullRequestState(state: PullRequest.State): String {
        return when (state) {
            PullRequest.State.OPEN -> "open"
            PullRequest.State.CLOSED -> "closed"
            else -> "all"
        }
    }
}