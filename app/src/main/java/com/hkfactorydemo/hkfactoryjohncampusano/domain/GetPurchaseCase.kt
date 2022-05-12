package com.hkfactorydemo.hkfactoryjohncampusano.domain

import com.hkfactorydemo.hkfactoryjohncampusano.data.PurchaseRepository
import com.hkfactorydemo.hkfactoryjohncampusano.domain.model.Purchase
import javax.inject.Inject

class GetPurchaseCase @Inject constructor(private val purchaseRepository: PurchaseRepository){
    suspend operator fun invoke():List<Purchase>{
        return purchaseRepository.getAllPurchasesFromDatabase()
    }
}