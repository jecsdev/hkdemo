package com.hkfactorydemo.hkfactoryjohncampusano.domain.model

import com.hkfactorydemo.hkfactoryjohncampusano.data.database.entities.PurchaseEntity
import com.hkfactorydemo.hkfactoryjohncampusano.data.model.PurchaseModel

data class Purchase (
        var customerName: String,
        var seller: String,
        var productName: String,
        var productPrice: Int?,
        var productQuantity: Int,
        var totalSold: Int)

fun PurchaseModel.toDomain() = Purchase(
        customerName = customerName,
        seller = seller, productName = productName, productPrice = productPrice
        ,productQuantity = productQuantity, totalSold = totalSold
)
fun PurchaseEntity.toDomain() = Purchase(
        customerName = customerName,
        seller = seller, productName = productName, productPrice = productPrice
        ,productQuantity = productQuantity, totalSold = totalSold
)


