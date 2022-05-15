package com.hkfactorydemo.hkfactoryjohncampusano.ui.view.adapters

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.hkfactorydemo.hkfactoryjohncampusano.R
import com.hkfactorydemo.hkfactoryjohncampusano.domain.model.Purchase
import com.hkfactorydemo.hkfactoryjohncampusano.ui.view.viewHolder.PurchaseViewHolder
import com.hkfactorydemo.hkfactoryjohncampusano.ui.viewModels.PurchaseViewModel
import javax.inject.Inject

class PurchaseAdapter @Inject constructor( private val purchaseList: MutableList<Purchase>, private val purchaseViewModel: PurchaseViewModel):
    RecyclerView.Adapter<PurchaseViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): PurchaseViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.row, viewGroup, false)
        return PurchaseViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: PurchaseViewHolder, position: Int) {
        val purchase = purchaseList[position]
        val purchaseCustomer = purchase.customerName
        val purchaseSeller = purchase.seller
        val purchaseTotal = purchase.totalSold
        val totalItems = purchase.totalItems
        val nameText = "Nombre: $purchaseCustomer"
        val sellerText = "Suplidor: $purchaseSeller"
        val total = "Total vendido: $purchaseTotal"
        val totalItemsText = "Cantidad de items: $totalItems"
        viewHolder.customerName.text = nameText
        viewHolder.seller.text = sellerText
        viewHolder.total.text = total
        viewHolder.totalItems.text = totalItemsText

        viewHolder.card.setOnLongClickListener {
            val context = viewHolder.card.context
            val builder = AlertDialog.Builder(context)
            builder.setTitle("Borrar")
            builder.setMessage("Esta seguro de querer borrar este elemento?")
            builder.setPositiveButton("Si") { _, _ ->
                purchaseViewModel.purchaseModelList.value?.removeAt(position)
                purchaseViewModel.removePurchase(position)
                notifyItemRemoved(position)


            }
            builder.setNegativeButton("Cancelar", null).show()
            return@setOnLongClickListener true
        }


    }

    override fun getItemCount(): Int {
        return purchaseList.size
    }
}