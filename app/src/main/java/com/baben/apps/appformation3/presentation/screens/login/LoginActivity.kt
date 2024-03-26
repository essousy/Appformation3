package com.baben.apps.appformation3.presentation.screens.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.baben.apps.appformation3.core.bases.BaseActivities
import com.baben.apps.appformation3.databinding.ActivityLoginBinding
import com.baben.apps.appformation3.presentation.screens.home.HomeActivity
import com.baben.apps.appformation3.presentation.screens.signup.SignupActivity

class LoginActivity : BaseActivities() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupActions()
    }

    private fun setupActions() {
        binding.uiLoginButton.setOnClickListener(::onLoginButtonClicked)
        binding.uiSignupButton.setOnClickListener(::onSignupButtonClicked)
    }

    private fun onLoginButtonClicked(view: View?) {
       // TODO("implement real login action")
        startActivity(Intent(context, HomeActivity::class.java))
        finish()
    }

    private fun onSignupButtonClicked(view: View?) {
        startActivity(Intent(context, SignupActivity::class.java))
    }

}