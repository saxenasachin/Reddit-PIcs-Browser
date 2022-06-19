package com.saxenasachin.data.repositories

import com.saxenasachin.data.models.redditpics.RedditPicEntity
import io.reactivex.Single

/**
Created by Sachin Saxena on 19/06/22.
 */
interface RedditDataStore {

    fun getRedditPics(): Single<RedditPicEntity>
}