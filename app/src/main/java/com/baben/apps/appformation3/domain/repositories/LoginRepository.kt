package com.baben.apps.appformation3.domain.repositories

import com.baben.apps.appformation3.core.networking.NetworkErrorException
import com.baben.apps.appformation3.domain.models.Login

interface LoginRepository {


    @Throws(NetworkErrorException::class)
    fun login(model: Login?): LoginResult?

    enum class LoginResult {
        SUCCESS,
        AUTH_ERROR,
        GENERAL_ERROR
    }

}