package com.hkfactorydemo.hkfactoryjohncampusano.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hkfactorydemo.hkfactoryjohncampusano.databinding.ActivityPurchaseListBinding

class PurchaseListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPurchaseListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPurchaseListBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}