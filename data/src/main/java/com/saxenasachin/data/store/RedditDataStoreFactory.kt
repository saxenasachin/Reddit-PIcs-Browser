package com.saxenasachin.data.store

import com.saxenasachin.data.repositories.RedditDataStore
import javax.inject.Inject

/**
Created by Sachin Saxena on 19/06/22.
 */
class RedditDataStoreFactory @Inject constructor(
    private val redditRemoteDataStore: RedditRemoteDataStore
) {

    fun getRemoteDataStore(): RedditDataStore {
        return redditRemoteDataStore
    }
}