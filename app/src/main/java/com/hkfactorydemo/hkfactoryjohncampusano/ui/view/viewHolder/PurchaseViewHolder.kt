package com.hkfactorydemo.hkfactoryjohncampusano.ui.view.viewHolder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hkfactorydemo.hkfactoryjohncampusano.R

class PurchaseViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    val productName: TextView = itemView.findViewById(R.id.tvProductName)
    val customerName: TextView = itemView.findViewById(R.id.tvCustomerName)
    val quantity: TextView = itemView.findViewById(R.id.tvCount)
    val seller: TextView = itemView.findViewById(R.id.tvSeller)
    val total: TextView = itemView.findViewById(R.id.tvTotalMount)
}