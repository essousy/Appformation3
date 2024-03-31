package com.baben.apps.appformation3.core.bases

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.baben.apps.appformation3.data.remote.retrofit.UserApi
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
abstract class BaseActivities : AppCompatActivity() {

    protected lateinit var context : Activity
    @Inject
    lateinit var userApi: UserApi

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        this.initData()
    }

    override fun onResume() {
        super.onResume()
        this.initData()
    }

    private fun initData(){
     context = this
    }
}