package com.baben.apps.appformation3.data.mappers

import com.baben.apps.appformation3.data.remote.models.UserDto
import com.baben.apps.appformation3.domain.models.User


fun UserDto.toUser(): User {
    return User(
        email = email ?: "",
        id = id ?: -1,
        firstname = name?.firstname ?: "",
        lastname = name?.lastname ?: "",
        password = password ?: "",
        phone = phone ?: "",
        username = username ?: ""
    )
}
