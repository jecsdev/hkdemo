package com.hkfactorydemo.hkfactoryjohncampusano.ui.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hkfactorydemo.hkfactoryjohncampusano.R
import com.hkfactorydemo.hkfactoryjohncampusano.data.model.PurchaseModel
import com.hkfactorydemo.hkfactoryjohncampusano.ui.view.viewHolder.PurchaseViewHolder
import javax.inject.Inject

class PurchaseAdapter @Inject constructor(private val purchaseList: MutableList<PurchaseModel>):
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
        val purchaseTotal = purchase.totalSold

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