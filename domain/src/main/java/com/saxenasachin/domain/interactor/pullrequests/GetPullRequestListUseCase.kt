package com.saxenasachin.domain.interactor.pullrequests

import com.saxenasachin.domain.RedditRepository
import com.saxenasachin.domain.executor.PostExecutionThread
import com.saxenasachin.domain.executor.ThreadExecutor
import com.saxenasachin.domain.interactor.core.SingleUseCase
import com.saxenasachin.domain.models.pullrequest.PullRequest
import io.reactivex.Single
import javax.inject.Inject

/**
Created by Sachin Saxena on 19/06/22.
 */
class GetPullRequestListUseCase @Inject constructor(
    private val redditRepository: RedditRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) : SingleUseCase<GetPullRequestListUseCase.Params, List<PullRequest>>(
    threadExecutor,
    postExecutionThread
) {

    override fun buildUseCaseObservable(requestValues: Params?): Single<List<PullRequest>> {
        val requestBody = requestValues!!
        return redditRepository.getPullRequestList(
            requestBody.username,
            requestBody.repositoryName,
            requestBody.state
        )
    }

    /**
     * [username] git username,
     * [repositoryName] repository's name to fetch its pull request.
     * [state] to filter Pull request's state [open, closed, all]
     */
    data class Params(
        val username: String,
        val repositoryName: String,
        val state: PullRequest.State
    )
}