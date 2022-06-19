package com.saxenasachin.presentation.views.mappers.user

import com.saxenasachin.domain.models.user.User
import com.saxenasachin.presentation.mapper.Mapper
import com.saxenasachin.presentation.views.views.UserView
import javax.inject.Inject

class UserViewMapper @Inject constructor() : Mapper<UserView, User> {
    override fun mapToView(type: User): UserView {
        return UserView(
            userName = type.userName,
            profilePic = type.profilePic
        )
    }
}