package com.baben.apps.appformation3.domain.models

import com.baben.apps.appformation3.data.remote.models.Name

data class User(
    val email: String,
    val id: Int,
    val firstname: String,
    val lastname: String,
    val password: String,
    val phone: String,
    val username: String
)
