package com.saxenasachin.remote.mappers.reddit.pull_request

import com.saxenasachin.data.models.PullRequestEntity
import com.saxenasachin.remote.mappers.EntityMapper
import com.saxenasachin.remote.mappers.reddit.user.UserEntityMapper
import com.saxenasachin.remote.models.reddit.pr.GithubPullRequest
import com.saxenasachin.remote.models.reddit.user.GithubUser
import javax.inject.Inject

class PullRequestEntityMapper @Inject constructor(private val userEntityMapper: UserEntityMapper) :
    EntityMapper<GithubPullRequest, PullRequestEntity> {

    override fun mapFromModel(model: GithubPullRequest): PullRequestEntity {
        return PullRequestEntity(
            id = model.id ?: -1,
            desc = model.body ?: "No description ",
            user = userEntityMapper.mapFromModel(model.user ?: GithubUser()),
            title = model.title ?: "No title",
            createdAt = model.createdAt ?: "",
            closedAt = model.closedAt ?: ""
        )
    }
}