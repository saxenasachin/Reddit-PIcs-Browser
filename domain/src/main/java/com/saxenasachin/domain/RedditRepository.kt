package com.saxenasachin.domain

import com.saxenasachin.domain.models.piclist.RedditPicModel
import io.reactivex.Single

/**
Created by Sachin Saxena on 19/06/22.
 */
interface RedditRepository {

    fun getRedditPics(): Single<RedditPicModel>
}