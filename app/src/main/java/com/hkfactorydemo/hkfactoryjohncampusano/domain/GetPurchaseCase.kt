package com.hkfactorydemo.hkfactoryjohncampusano.domain

import com.hkfactorydemo.hkfactoryjohncampusano.data.PurchaseRepository
import com.hkfactorydemo.hkfactoryjohncampusano.data.database.entities.PurchaseEntity
import com.hkfactorydemo.hkfactoryjohncampusano.domain.model.Purchase
import javax.inject.Inject

class GetPurchaseCase @Inject constructor(private val purchaseRepository: PurchaseRepository){
    suspend operator fun invoke():List<Purchase>{
        return purchaseRepository.getAllPurchasesFromDatabase()
    }

    suspend fun insertPurchase(purchase: PurchaseEntity){
        return purchaseRepository.insertPurchases(purchase)
    }

    suspend fun deleteAllPurchases(purchase: Purchase){
        return purchaseRepository.deletePurchase(purchase)
    }

}