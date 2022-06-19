package com.saxenasachin.remote.services.github

import com.saxenasachin.remote.models.picslist.RedditPic
import io.reactivex.Single
import retrofit2.http.GET

interface RedditService {

    @GET("/r/pics/.json")
    fun getRedditPics(): Single<RedditPic>
}
