package com.hkfactorydemo.hkfactoryjohncampusano.ui.view.viewHolder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hkfactorydemo.hkfactoryjohncampusano.R

class DetailsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
     val itemName: TextView = itemView.findViewById(R.id.itemName)
     val itemCount: TextView = itemView.findViewById(R.id.itemCount)
     val itemCode: TextView = itemView.findViewById(R.id.codeItem)
     val itemSubtotal: TextView = itemView.findViewById(R.id.subtotalItem)
}