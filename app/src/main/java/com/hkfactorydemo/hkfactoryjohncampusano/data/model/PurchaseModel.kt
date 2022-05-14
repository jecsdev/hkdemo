package com.hkfactorydemo.hkfactoryjohncampusano.data.model

import com.hkfactorydemo.hkfactoryjohncampusano.data.database.entities.PurchaseEntity

data class PurchaseModel(
    var customerName: String,
    var seller: String,
    var productName: String,
    var productPrice: Int?,
    var productCode: String,
    var ncf: String,
    var vatId: String,
    var productQuantity: Int,
    var subtotal: Int,
    var totalSold: Int
)

fun PurchaseEntity.toDomain() = PurchaseModel(customerName = customerName,
    seller = seller, productName = productName, productPrice = productPrice
    ,productQuantity = productQuantity, totalSold = totalSold
, ncf = ncf, vatId = vatId, subtotal = subtotal, productCode = productCode
)