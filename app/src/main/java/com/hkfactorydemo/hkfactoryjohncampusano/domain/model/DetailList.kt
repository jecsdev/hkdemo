package com.hkfactorydemo.hkfactoryjohncampusano.domain.model

import java.io.Serializable
@kotlinx.serialization.Serializable
data class DetailList( var productCode: String,
                       var productQuantity: Int,
                       var productName: String,
                       var productPrice: Int,
                       var subtotal: Int)
