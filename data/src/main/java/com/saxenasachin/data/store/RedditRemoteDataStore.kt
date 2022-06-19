package com.saxenasachin.data.store

import com.saxenasachin.data.models.redditpics.RedditPicEntity
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

    override fun getRedditPics(): Single<RedditPicEntity> {
        return redditRemote.getRedditPics()
    }
}