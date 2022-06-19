package com.saxenasachin.remote.mappers.reddit.user

import com.saxenasachin.data.models.UserEntity
import com.saxenasachin.remote.mappers.EntityMapper
import com.saxenasachin.remote.models.user.GithubUser
import javax.inject.Inject

class UserEntityMapper @Inject constructor() : EntityMapper<GithubUser, UserEntity> {
    override fun mapFromModel(model: GithubUser): UserEntity {
        return UserEntity(
            userName = model.login ?: "",
            profilePic = model.avatarUrl ?: ""
        )
    }
}