package com.baben.apps.appformation3.presentation.screens.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.baben.apps.appformation3.core.app.AppConfig
import com.baben.apps.appformation3.core.bases.BaseActivities
import com.baben.apps.appformation3.databinding.ActivitySplashBinding
import com.baben.apps.appformation3.presentation.screens.login.LoginActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivities() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        delayedSplash()
    }

    private fun delayedSplash() {
        Handler(Looper.getMainLooper()).postDelayed(
            { this.displayNextScreen() },
            AppConfig.SPLASH_DELAY_MILLIS
        )
    }

    private fun displayNextScreen() {
        //TODO :: check if user already logged or not
        //TODO :: if is already logged go to HomeActivity
        //TODO :: if is not logged go to LoginActivity
        startActivity(Intent(context, LoginActivity::class.java))
    }
}