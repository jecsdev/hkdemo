package com.hkfactorydemo.hkfactoryjohncampusano.ui.view.viewHolder

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.hkfactorydemo.hkfactoryjohncampusano.R

class PurchaseViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    val customerName: TextView = itemView.findViewById(R.id.tvCustomerName)
    val seller: TextView = itemView.findViewById(R.id.tvSeller)
    val total: TextView = itemView.findViewById(R.id.tvTotalMount)
    val totalItems: TextView = itemView.findViewById(R.id.tvCount)
    val card: CardView = itemView.findViewById(R.id.cardView)
}