package com.saxenasachin.domain.interactor.piclist

import com.saxenasachin.domain.RedditRepository
import com.saxenasachin.domain.executor.PostExecutionThread
import com.saxenasachin.domain.executor.ThreadExecutor
import com.saxenasachin.domain.interactor.core.SingleUseCase
import com.saxenasachin.domain.models.piclist.RedditPicModel
import io.reactivex.Single
import javax.inject.Inject

/**
Created by Sachin Saxena on 19/06/22.
 */
class GetPicsListUseCase @Inject constructor(
    private val redditRepository: RedditRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) : SingleUseCase<GetPicsListUseCase.Params, RedditPicModel>(
    threadExecutor,
    postExecutionThread
) {

    override fun buildUseCaseObservable(requestValues: Params?): Single<RedditPicModel> {
        return redditRepository.getRedditPics()
    }

    data class Params(
        val unit: Unit
    )
}