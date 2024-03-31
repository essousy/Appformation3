package com.baben.apps.appformation3.data.remote.retrofit

import android.telecom.Call
import com.baben.apps.appformation3.data.remote.models.UserDto
import com.baben.apps.appformation3.domain.models.Login
import com.baben.apps.appformation3.domain.models.User
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {

    //TODO :: add Login and SingUp services here

    // login
    @POST("auth/login")
    fun loginUser(@Body request: Login): User
    @POST("users")
    fun registerUser(@Body request: UserDto): User
    // singUp
}