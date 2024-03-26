package com.baben.apps.appformation3.data.remote.repositories

import com.baben.apps.appformation3.domain.models.Login
import com.baben.apps.appformation3.domain.repositories.LoginRepository

class ApiLoginRepository : LoginRepository {

    override fun login(model: Login?): LoginRepository.LoginResult? {
        TODO("Not yet implemented")
    }

}