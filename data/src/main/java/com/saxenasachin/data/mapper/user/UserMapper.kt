package com.saxenasachin.data.mapper.user

import com.saxenasachin.data.mapper.Mapper
import com.saxenasachin.data.models.UserEntity
import com.saxenasachin.domain.models.user.User
import javax.inject.Inject

/**
Created by Sachin Saxena on 19/06/22.
 */
class UserMapper @Inject constructor() : Mapper<UserEntity, User> {

    override fun mapFromEntity(type: UserEntity): User {
        return User(
            userName = type.userName,
            profilePic = type.profilePic
        )
    }

    override fun mapToEntity(type: User): UserEntity {
        return UserEntity(
            userName = type.userName,
            profilePic = type.profilePic
        )
    }
}