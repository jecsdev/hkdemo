package com.hkfactorydemo.hkfactoryjohncampusano.data.model

data class Purchase(
    var customerName: String?,
    var seller: String?,
    var productName: String?,
    var productPrice: Int?,
    var productQuantity: Int,
    var totalSelled: Int
)