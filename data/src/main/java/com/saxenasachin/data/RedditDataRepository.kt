package com.saxenasachin.data

import com.saxenasachin.data.mapper.piclist.PicModelMapper
import com.saxenasachin.data.store.RedditDataStoreFactory
import com.saxenasachin.domain.RedditRepository
import com.saxenasachin.domain.models.piclist.RedditPicModel
import io.reactivex.Single
import javax.inject.Inject

/**
Created by Sachin Saxena on 19/06/22.
 */
class RedditDataRepository @Inject constructor(
    private val picModelMapper: PicModelMapper,
    private val redditDataStoreFactory: RedditDataStoreFactory
) : RedditRepository {

    override fun getRedditPics(): Single<RedditPicModel> {
        return redditDataStoreFactory.getRemoteDataStore()
            .getRedditPics()
            .map {
                picModelMapper.mapFromEntity(it)
            }
    }
}