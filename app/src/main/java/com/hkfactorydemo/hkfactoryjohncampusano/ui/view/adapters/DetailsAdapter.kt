package com.hkfactorydemo.hkfactoryjohncampusano.ui.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hkfactorydemo.hkfactoryjohncampusano.R
import com.hkfactorydemo.hkfactoryjohncampusano.domain.model.Details
import com.hkfactorydemo.hkfactoryjohncampusano.ui.view.viewHolder.DetailsViewHolder
import javax.inject.Inject

class DetailsAdapter @Inject constructor(private val detailList: MutableList<Details>) :
RecyclerView.Adapter<DetailsViewHolder>(){
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): DetailsViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.details_row, viewGroup, false)
        return DetailsViewHolder(view)
    }

    override fun onBindViewHolder(purchaseHolder: DetailsViewHolder, position: Int) {
        val subtotalText: String
        val subtotal: Int
        val purchase = detailList[position]
        val productName = purchase.productName
        val productCount = purchase.productQuantity
        val productCode = purchase.productCode
        subtotalText = "$productCount x ${purchase.productPrice}"
        purchaseHolder.itemName.text = productName
        purchaseHolder.itemCount.text = subtotalText
        purchaseHolder.itemCode.text = productCode
        subtotal = productCount * purchase.productPrice!!
        purchaseHolder.itemSubtotal.text = subtotal.toString()
    }

    override fun getItemCount(): Int {
        return detailList.size
    }

}