package com.hkfactorydemo.hkfactoryjohncampusano.domain.model

import com.hkfactorydemo.hkfactoryjohncampusano.data.database.entities.PurchaseEntity
import com.hkfactorydemo.hkfactoryjohncampusano.data.model.PurchaseModel

data class Purchase (
        var customerName: String,
        var seller: String,
        var productName: String,
        var productPrice: Int?,
        var ncf: String?,
        var vatId: String,
        var productCode: String,
        var productQuantity: Int,
        var subtotal: Int,
        var totalItems: Int,
        var totalSold: Int)


fun PurchaseEntity.toDomain() = Purchase(
        customerName = customerName,
        seller = seller, productName = productName, productPrice = productPrice
        ,productQuantity = productQuantity, totalSold = totalSold
,ncf = ncf
, vatId = vatId, productCode = productCode, subtotal = subtotal
, totalItems = totalItems
)

fun Details.toDomain() = Details(
        productCode = productCode,
        productQuantity = productQuantity,
        productPrice = productPrice,
        productName =  productName,
        subtotal = subtotal
)


