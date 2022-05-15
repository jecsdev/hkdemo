package com.hkfactorydemo.hkfactoryjohncampusano.ui.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.hkfactorydemo.hkfactoryjohncampusano.R
import com.hkfactorydemo.hkfactoryjohncampusano.data.model.PurchaseModel
import com.hkfactorydemo.hkfactoryjohncampusano.domain.model.Purchase
import com.hkfactorydemo.hkfactoryjohncampusano.ui.view.viewHolder.PurchaseViewHolder
import com.hkfactorydemo.hkfactoryjohncampusano.ui.viewModels.PurchaseViewModel
import javax.inject.Inject

class PurchaseAdapter @Inject constructor( private val purchaseList: List<Purchase>):
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

        viewHolder.customerName.text = purchaseCustomer
        viewHolder.seller.text = purchaseSeller
        viewHolder.total.text = purchaseTotal.toString()

    }

    override fun getItemCount(): Int {
        return purchaseList.size
    }
}