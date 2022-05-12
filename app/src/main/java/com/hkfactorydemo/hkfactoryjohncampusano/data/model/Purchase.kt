package com.hkfactorydemo.hkfactoryjohncampusano.data.model

import com.hkfactorydemo.hkfactoryjohncampusano.data.database.entities.PurchaseEntity

data class Purchase(
    var customerName: String,
    var seller: String,
    var productName: String,
    var productPrice: Int?,
    var productQuantity: Int,
    var totalSelled: Int
)

fun PurchaseEntity.toDomain() = Purchase(customerName = customerName,
    seller = seller, productName = productName, productPrice = productPrice
    ,productQuantity = productQuantity, totalSelled = totalSelled
)