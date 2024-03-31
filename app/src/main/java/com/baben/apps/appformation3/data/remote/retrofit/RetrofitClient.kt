package com.baben.apps.appformation3.data.remote.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    lateinit var user_api: UserApi
    private val base_url = "https://fakestoreapi.com/"

    fun getRetrofit() : Retrofit {

        val retrofit = Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        user_api = retrofit.create(UserApi::class.java)
        return retrofit
    }


}