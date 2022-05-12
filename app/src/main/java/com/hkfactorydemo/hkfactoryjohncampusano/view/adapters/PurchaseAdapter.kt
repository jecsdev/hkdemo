package com.hkfactorydemo.hkfactoryjohncampusano.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hkfactorydemo.hkfactoryjohncampusano.R
import com.hkfactorydemo.hkfactoryjohncampusano.data.model.Purchase
import com.hkfactorydemo.hkfactoryjohncampusano.view.viewHolder.PurchaseViewHolder

class PurchaseAdapter (private val purchaseList: MutableList<Purchase>):
    RecyclerView.Adapter<PurchaseViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): PurchaseViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.row, viewGroup, false)
        return PurchaseViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: PurchaseViewHolder, position: Int) {
        val purchase = purchaseList[position]
        val purchaseCustomer = purchase.customerName
        val purchaseSeller = purchase.seller
        val purchaseProduct = purchase.productName
        val purchaseQuantity = purchase.productQuantity
        val purchaseTotal = purchase.totalSelled

        viewHolder.customerName.text = purchaseCustomer
        viewHolder.seller.text = purchaseSeller
        viewHolder.productName.text = purchaseProduct
        viewHolder.quantity.text = purchaseQuantity.toString()
        viewHolder.total.text = purchaseTotal.toString()

    }

    override fun getItemCount(): Int {
        return purchaseList.size
    }
}