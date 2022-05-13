package com.hkfactorydemo.hkfactoryjohncampusano.ui.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hkfactorydemo.hkfactoryjohncampusano.databinding.ActivityPurchaseListBinding
import com.hkfactorydemo.hkfactoryjohncampusano.ui.view.adapters.PurchaseAdapter
import com.hkfactorydemo.hkfactoryjohncampusano.ui.viewModels.PurchaseViewModel

class PurchaseListActivity : AppCompatActivity() {

    private var viewManager = LinearLayoutManager(this)
    private val viewModel: PurchaseViewModel by viewModels()
    private lateinit var binding: ActivityPurchaseListBinding
    private lateinit var mainRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPurchaseListBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.getPurchase()

        mainRecyclerView = binding.recyclerMain

        initializeAdapter()


    }

    private fun initializeAdapter() {
        mainRecyclerView.layoutManager = viewManager
        observeData()
    }

    private fun observeData() {
        viewModel.purchaseModel
        viewModel.purchaseModel.observe(
            this
        ) {
            mainRecyclerView.adapter = PurchaseAdapter(viewModel, it, this)
            mainRecyclerView.adapter?.notifyDataSetChanged()
        }
    }

}