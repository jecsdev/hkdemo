package com.hkfactorydemo.hkfactoryjohncampusano.ui.view.activities

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hkfactorydemo.hkfactoryjohncampusano.databinding.ActivityPurchaseListBinding
import com.hkfactorydemo.hkfactoryjohncampusano.ui.view.adapters.PurchaseAdapter
import com.hkfactorydemo.hkfactoryjohncampusano.ui.viewModels.PurchaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PurchaseListActivity : AppCompatActivity() {

    private var viewManager = LinearLayoutManager(this)
    private val viewModel: PurchaseViewModel by viewModels()
    private lateinit var binding: ActivityPurchaseListBinding
    private lateinit var mainRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.title = "Lista de compras"
        binding = ActivityPurchaseListBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.getPurchase()

        mainRecyclerView = binding.recyclerMain
        binding.layoutDelete.actionBarTitle.text = "Lista de compras"
        initializeAdapter()

        binding.layoutDelete.delete.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Borrar")
            builder.setMessage("¿Esta seguro de querer borrar los elementos de la lista?" +
                    "Una vez hecho esto, no hay vuelta atrás.")
            builder.setPositiveButton("Si") { _, _ ->
                viewModel.removePurchase()
            }
            builder.setNegativeButton("Cancelar", null).show()


        }


    }

    private fun initializeAdapter() {
        mainRecyclerView.layoutManager = viewManager
        observeData()
    }

    private fun observeData(){
        viewModel.purchaseModelList.observe(this) {
            mainRecyclerView.adapter = PurchaseAdapter( it, viewModel)
            mainRecyclerView.adapter?.notifyDataSetChanged()
        }
    }

}