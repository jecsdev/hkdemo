package com.hkfactorydemo.hkfactoryjohncampusano.data

import com.hkfactorydemo.hkfactoryjohncampusano.data.database.dao.PurchaseDao
import com.hkfactorydemo.hkfactoryjohncampusano.data.database.entities.PurchaseEntity
import com.hkfactorydemo.hkfactoryjohncampusano.data.model.Purchase
import com.hkfactorydemo.hkfactoryjohncampusano.data.model.toDomain
import javax.inject.Inject

class PurchaseRepository @Inject constructor(
    private val purchaseDao: PurchaseDao
){
    suspend fun getAllPurchasesFromDatabase(): List<Purchase>{
        val response: List<PurchaseEntity> = purchaseDao.getAllPurchases()
        return response.map { it.toDomain() }
    }
}