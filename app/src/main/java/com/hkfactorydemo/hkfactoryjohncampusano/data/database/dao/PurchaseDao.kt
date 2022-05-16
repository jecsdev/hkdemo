package com.hkfactorydemo.hkfactoryjohncampusano.data.database.dao

import androidx.room.*
import com.hkfactorydemo.hkfactoryjohncampusano.data.database.entities.PurchaseEntity
import com.hkfactorydemo.hkfactoryjohncampusano.domain.model.Purchase

@Dao
interface PurchaseDao {
    @Query("SELECT * FROM purchase_table ORDER BY id DESC")
    suspend fun getAllPurchases(): List<PurchaseEntity>

    @Insert
    suspend fun insertPurchase(purchase: PurchaseEntity)

   @Query("DELETE FROM purchase_table")
    suspend fun deleteAllPurchases()
}