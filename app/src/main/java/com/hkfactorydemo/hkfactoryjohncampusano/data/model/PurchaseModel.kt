package com.hkfactorydemo.hkfactoryjohncampusano.data.model

import com.hkfactorydemo.hkfactoryjohncampusano.data.database.entities.PurchaseEntity

data class PurchaseModel(
    var customerName: String,
    var seller: String,
    var productName: String,
    var productCode: String,
    var ncf: String,
    var vatId: String,
    var productQuantity: Int,
    var totalSold: Int,
    var totalItems: Int
)
