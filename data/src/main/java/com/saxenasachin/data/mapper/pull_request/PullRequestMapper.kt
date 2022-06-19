package com.saxenasachin.data.mapper.pull_request

import com.saxenasachin.data.mapper.Mapper
import com.saxenasachin.data.models.PullRequestEntity
import com.saxenasachin.data.models.UserEntity
import com.saxenasachin.domain.models.pullrequest.PullRequest
import com.saxenasachin.domain.models.user.User
import javax.inject.Inject

/**
Created by Sachin Saxena on 19/06/22.
 */
class PullRequestMapper @Inject constructor() : Mapper<PullRequestEntity, PullRequest> {

    override fun mapFromEntity(type: PullRequestEntity): PullRequest {
        return PullRequest(
            id = type.id,
            desc = type.desc,
            closedAt = type.closedAt,
            createdAt = type.createdAt,
            title = type.title,
            user = User(type.user.userName, type.user.profilePic)
        )
    }

    override fun mapToEntity(type: PullRequest): PullRequestEntity {
        return PullRequestEntity(
            id = type.id,
            desc = type.desc,
            closedAt = type.closedAt,
            createdAt = type.createdAt,
            title = type.title,
            user = UserEntity(type.user.userName, type.user.profilePic)
        )
    }
}