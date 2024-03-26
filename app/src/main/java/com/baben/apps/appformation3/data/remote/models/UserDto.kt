package com.baben.apps.appformation3.data.remote.models

//NB : "The DTO Pattern (Data Transfer Object)"

data class UserDto(
    val address: Address?,
    val email: String?,
    val id: Int?,
    val name: Name?,
    val password: String?,
    val phone: String?,
    val username: String?
)