package com.hkfactorydemo.hkfactoryjohncampusano.data

import com.hkfactorydemo.hkfactoryjohncampusano.data.database.dao.PurchaseDao
import com.hkfactorydemo.hkfactoryjohncampusano.data.database.entities.PurchaseEntity
import com.hkfactorydemo.hkfactoryjohncampusano.domain.model.Purchase
import com.hkfactorydemo.hkfactoryjohncampusano.domain.model.toDomain
import javax.inject.Inject

class PurchaseRepository @Inject constructor(
    private val purchaseDao: PurchaseDao
){
    suspend fun getAllPurchasesFromDatabase(): List<Purchase> {
        val response: List<PurchaseEntity> = purchaseDao.getAllPurchases()
        return response.map { it.toDomain() }
    }

    suspend fun insertPurchases(purchase: PurchaseEntity){
        purchaseDao.insertPurchase(purchase)
    }

    suspend fun deletePurchase(){
        purchaseDao.deleteAllPurchases()
    }
}
