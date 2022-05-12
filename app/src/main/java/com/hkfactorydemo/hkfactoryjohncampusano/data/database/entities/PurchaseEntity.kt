package com.hkfactorydemo.hkfactoryjohncampusano.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hkfactorydemo.hkfactoryjohncampusano.data.model.Purchase

@Entity(tableName = "purchase_table")
data class PurchaseEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "customer_name") val customerName: String,
    @ColumnInfo(name = "seller") val seller: String,
    @ColumnInfo(name = "product_name") val productName: String,
    @ColumnInfo(name = "product_quantity") val productQuantity: Int,
    @ColumnInfo(name = "product_price") val productPrice: Int,
    @ColumnInfo(name = "total_selled") val totalSelled: Int
)

fun Purchase.toDatabase() = PurchaseEntity(
    customerName = customerName, seller = seller,
    productName = productName,
    productQuantity = productQuantity,
    productPrice = productQuantity,
    totalSelled = totalSelled
)