package com.saxenasachin.remote

import com.saxenasachin.data.models.redditpics.RedditPicEntity
import com.saxenasachin.data.repositories.RedditRemote
import com.saxenasachin.remote.mappers.reddit.piclist.RedditPicsEntityMapper
import com.saxenasachin.remote.services.github.RedditService
import io.reactivex.Single
import javax.inject.Inject

class RedditRemoteRepositoryImp @Inject constructor(
    private val redditService: RedditService,
    private val redditPicsEntityMapper: RedditPicsEntityMapper
) : RedditRemote {

    override fun getRedditPics(): Single<RedditPicEntity> {
        return redditService.getRedditPics()
            .map {
                redditPicsEntityMapper.mapFromModel(it)
            }
    }
}