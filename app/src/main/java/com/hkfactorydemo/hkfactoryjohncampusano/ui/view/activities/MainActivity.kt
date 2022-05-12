package com.hkfactorydemo.hkfactoryjohncampusano.ui.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hkfactorydemo.hkfactoryjohncampusano.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}