package com.saxenasachin.remote.services.github

import com.saxenasachin.remote.models.pics.RedditPic
import com.saxenasachin.remote.models.pr.GithubPullRequest
import com.saxenasachin.remote.models.repo.GithubSingleRepo
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RedditService {

    @GET("users/{username}/repos")
    fun getUserRepositories(
        @Path("username") username: String
    ): Single<List<GithubSingleRepo>>

    @GET("/repos/{username}/{repo_name}/pulls")
    fun getPullRequestForGithubRepo(
        @Path("username") username: String,
        @Path("repo_name") repoName: String,
        @Query("state") state: String = "all"
    ): Single<List<GithubPullRequest>>

    @GET("/r/pics/.json")
    fun getRedditPics(): Single<RedditPic>
}
