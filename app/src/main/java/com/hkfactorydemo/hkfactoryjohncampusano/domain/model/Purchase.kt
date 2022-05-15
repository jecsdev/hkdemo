package com.hkfactorydemo.hkfactoryjohncampusano.domain.model

import com.hkfactorydemo.hkfactoryjohncampusano.data.database.entities.PurchaseEntity
import com.hkfactorydemo.hkfactoryjohncampusano.data.model.PurchaseModel

data class Purchase (
        var customerName: String,
        var seller: String,
        var ncf: String?,
        var vatId: String,
        var totalItems: Int,
        var totalSold: Int)


fun PurchaseEntity.toDomain() = Purchase(
        customerName = customerName,
        seller = seller ,totalSold = totalSold
,ncf = ncf
, vatId = vatId,
totalItems = totalItems
)



