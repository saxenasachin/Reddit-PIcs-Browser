package com.saxenasachin.domain.interactor.user_repos

import com.saxenasachin.domain.GitRepository
import com.saxenasachin.domain.executor.PostExecutionThread
import com.saxenasachin.domain.executor.ThreadExecutor
import com.saxenasachin.domain.interactor.core.SingleUseCase
import com.saxenasachin.domain.models.repo.GitSingleRepo
import io.reactivex.Single
import javax.inject.Inject

/**
Created by Sachin Saxena on 19/06/22.
 */
class GetUserRepositoryListUseCase @Inject constructor(
    private val gitRepository: GitRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) : SingleUseCase<GetUserRepositoryListUseCase.Params, List<GitSingleRepo>>(
    threadExecutor,
    postExecutionThread
) {

    override fun buildUseCaseObservable(requestValues: Params?): Single<List<GitSingleRepo>> {
        return gitRepository.getUserGitRepositories(requestValues!!.username)
    }

    /**
     * [username] to fetch user's repositories
     */
    data class Params(
        val username: String
    )
}