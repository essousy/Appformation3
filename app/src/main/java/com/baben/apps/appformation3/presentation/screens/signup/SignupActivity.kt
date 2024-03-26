package com.baben.apps.appformation3.presentation.screens.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.baben.apps.appformation3.R
import com.baben.apps.appformation3.core.bases.BaseActivities
import com.baben.apps.appformation3.databinding.ActivitySignupBinding
import com.baben.apps.appformation3.presentation.screens.login.LoginActivity

class SignupActivity : BaseActivities() {

    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupActions()
    }

    private fun setupActions() {
        binding.uiBackButton.setOnClickListener(::onBackButtonClicked)
        binding.uiSaveButton.setOnClickListener(::onSaveButtonClicked)
    }

    private fun onSaveButtonClicked(view: View?) {
        //TODO("Add save button real action")
        startActivity(Intent(context, LoginActivity::class.java))
        finish()
    }

    private fun onBackButtonClicked(view: View?) {
        finish()
    }
}