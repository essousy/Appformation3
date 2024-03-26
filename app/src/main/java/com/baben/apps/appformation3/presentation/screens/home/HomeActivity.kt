package com.baben.apps.appformation3.presentation.screens.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.baben.apps.appformation3.R
import com.baben.apps.appformation3.core.bases.BaseActivities
import com.baben.apps.appformation3.databinding.ActivityHomeBinding

class HomeActivity : BaseActivities() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
    }

    private fun setupUI() {
        binding.uiProductsRecyclerView.layoutManager = GridLayoutManager(this,2)
    }
}