package com.hkfactorydemo.hkfactoryjohncampusano.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hkfactorydemo.hkfactoryjohncampusano.data.model.PurchaseModel

@Entity(tableName = "purchase_table")
data class PurchaseEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "customer_name") val customerName: String,
    @ColumnInfo(name = "seller") val seller: String,
    @ColumnInfo(name = "ncf") val ncf: String,
    @ColumnInfo(name = "vatId") val vatId: String,
    @ColumnInfo(name = "total_items") val totalItems: Int,
    @ColumnInfo(name = "total_selled") val totalSold: Int
)


